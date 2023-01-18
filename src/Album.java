
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
  private   String albumName;
     private String artist;

   private List<song> songs; // just a reference

    public Album(String albumName, String artist) {
        this.albumName = albumName;
        this.artist = artist;
       this.songs = new ArrayList<>();// memory allocation
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<song> getSongs() {
        return songs;
    }

    public void setSongs(List<song> songs) {
        this.songs = songs;
    }

    public  boolean findSong(String title){

        for(song s : songs){
            if(s.getTitle().equals(title))
                return true;
             }
        return false;
    }

    void addSongToAlbum(String title , double duration){

        song s= new song(title,duration);
        // kya hm is parameter ko directly addSongAlbum me pass ni kr skte?
        if(findSong(s.getTitle())==true){
            System.out.println("Song already present");
        }
        else{
            songs.add(s);
            System.out.println("Added new song");
        }
        return;
    }
    //polymorphism concept
    public void addToPlaylistFromAlbum(String title , LinkedList<song> playList)
    {
        if(findSong(title) == true){
             for(song s : songs){
                 if(s.getTitle().equals(title))
                     playList.add(s);
                 System.out.println("New song added in PlayList");
                 break;
             }
          }
        else{
            System.out.println("Song is not present in Album");
        }
    }
    public void addToPlaylistFromAlbum(int trackNo,LinkedList<song> playList )
    {
       int index = trackNo-1;
       if(index>=0 && index<songs.size()){
           playList.add(songs.get(index));
           System.out.println("New song added in PlayList");
       }
       else {
           System.out.println("Invalid track Number");
       }
       return;

    }
}
