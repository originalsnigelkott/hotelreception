package com.company;

import java.util.ArrayList;

public class Floor {
    private int floorNo;
    public static final int NUMBER_OF_ROOMS_PER_FLOOR = 3;
    private ArrayList<Room> rooms = new ArrayList();

    public Floor(int floorNo) {
        this.floorNo = floorNo;
        int roomNo = 0;
        for (int i = 0; i < NUMBER_OF_ROOMS_PER_FLOOR; i++) {
            roomNo++;
            rooms.add(new Room(generateRoomNo(roomNo, floorNo)));
        }
    }

    private int generateRoomNo(int roomNo, int floorNo) {
        if (roomNo <= 10) {
            String concatenatedRoomNo = String.format("%d0%d", floorNo, roomNo);
            return Integer.parseInt(concatenatedRoomNo);
        } else {
            String concatenatedRoomNo = String.format("%d%d", floorNo, roomNo);
            return Integer.parseInt(concatenatedRoomNo);
        }
    }

    public void showRooms () {
        for (Room room:
                rooms) {
            System.out.println(room.toString());
        }
    }
}
