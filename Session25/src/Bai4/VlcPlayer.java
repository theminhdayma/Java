package Bai4;

class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {}

    @Override
    public void playVlc(String fileName) {
        System.out.println("Đang phát vlc: " + fileName);
    }
}
