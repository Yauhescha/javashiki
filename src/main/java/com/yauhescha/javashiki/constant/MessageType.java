package com.yauhescha.javashiki.constant;

public enum MessageType {
    INBOX("inbox"),
    PRIVATE("private"),
    SENT("sent"),
    NEWS("news"),
    NOTIFICATIONS("notifications");

    final String name;

    MessageType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
