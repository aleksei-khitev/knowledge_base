package ru.akhitev.kb.java6.multithreading.completable_future.coordination.compose;

class Email {
    private final String from;
    private boolean autoRead;

    Email(String from) { this.from = from; }

    String getFrom() { return from; }

    boolean isAutoRead() { return autoRead; }

    boolean isEmailForRead() { return !autoRead; }

    void setAutoRead(boolean autoRead) { this.autoRead = autoRead; }

    @Override
    public String toString() {
        return "Email{ from='" + from + '\'' +
                ", autoRead=" + autoRead + '}';
    }
}
