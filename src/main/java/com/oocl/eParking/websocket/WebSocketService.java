package com.oocl.eParking.websocket;

import com.google.gson.Gson;
import com.oocl.eParking.entity.ParkingLot;
import com.oocl.eParking.entity.ParkingPosition;
import com.oocl.eParking.exception.ParkingLotException;
import com.oocl.eParking.service.CarPositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/{id}")
@Component
public class WebSocketService {

  private static final Map<String, Session> clients = new ConcurrentHashMap<>();
  private final Logger log = LoggerFactory.getLogger(WebSocketService.class);

  private static CarPositionService carPositionService;

  @Autowired
  public void setCarPositionService(CarPositionService carPositionService) {
    WebSocketService.carPositionService = carPositionService;
  }

  @OnOpen
  public void onOpen(Session session) {
    log.info("New Connection: {}", session.getId());
    // 将新用户存入在线的组
    clients.put(session.getId(), session);
  }

  @OnClose
  public void onClose(Session session) {
    log.info("Connection Lost, id为:{}", session.getId());
    // 将掉线的用户移除在线的组里
    clients.remove(session.getId());
  }

  @OnError
  public void onError(Throwable throwable) {
    throwable.printStackTrace();
  }

  @OnMessage
  public void onMessage(String message) {
    Gson gson = new Gson();
    try {
      ParkingLot parkingLot = carPositionService.reserveParkingPosition(Integer.parseInt(message));
      List<ParkingPosition> allParkingPosition = carPositionService.getAllParkingPosition(parkingLot.getId());
      sendAll(gson.toJson(allParkingPosition));
    } catch (ParkingLotException parkingLotException) {
      log.error(parkingLotException.getMessage());
    }
  }

  private void sendAll(String message) {
    clients.forEach((k, v) -> v.getAsyncRemote().sendText(message));
  }
}
