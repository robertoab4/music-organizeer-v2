import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    
    /**
     * List all files in the collection
     
    public void listAllFiles(){
        int position = 0;
        for (String filename : files){
            System.out.println(position +". " + filename);
            System.out.println();
            position++;
        }
    }
    */
   
    public void listAllFiles(){
        int index = 0;
        while (index < files.size()){
            String filename = files.get(index);
            System.out.println(filename);
            System.out.println();
            index++;           
        }
        
    }
    
    public void listMatching(String searchString){
        boolean coincidence = false;
        for (String filename : files){
            if(filename.contains(searchString)){
                System.out.println(filename);
                System.out.println();
                coincidence = true;
            }                        
        }
        if(coincidence == false){
                System.out.println("El texto introducido no se encuentra en la lista");
                System.out.println();               
            }
        
    }
    
    public void playSamplesArtist(String searchString){
        for (String filename : files){
            if(filename.contains(searchString)){
                player.playSample(filename);
            }
        }
    }
    
    /* NO SE PUEDEN BORRAR ELMENTOS CON UN BUCLE FOR EACH
     * public void deleteSongsWithText(String deleteThisSongs){
        for (String filename : files){
            if(filename.contains(deleteThisSongs)){
                files.remove(filename);
            }
        }
    }
    */
}
