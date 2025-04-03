package Bai4;

class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        System.out.println("Đang phát mp4: " + fileName);
    }

    @Override
    public void playVlc(String fileName) {}
}
