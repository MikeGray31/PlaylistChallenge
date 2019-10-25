package io.zipcoder;

public class Music {

    private String[] playList;
    private int[] selectindex;
    private int[] diff;
    private int Duplicates;

    public Music(String[] playList){
        this.playList = playList;
        selectindex = new int[playList.length];
    }

    public Integer selection(Integer startIndex, String selection) {

        //finds the indices of the song selected
        int[] selectindex = selectIndex(playList, selection);


        //finds the smallest path for all copies of the song
        diff = new int[selectindex.length];
        for(int i = 0; i < selectindex.length; i++){
            if(Math.abs(selectindex[i] - startIndex) <= playList.length / 2.0 && selectindex[i] > 0){
                diff[i] = Math.abs(selectindex[i] - startIndex);
            }
            else if(Math.abs(selectindex[i] - startIndex) >= playList.length / 2.0 && selectindex[i] > 0){
                diff[i] = playList.length - Math.abs(selectindex[i] - startIndex);
            }
        }
        int shortest = diff[0];
        for (int s : diff){
            if(s < shortest && s > 0){
                shortest = s;
            }
        }
        return shortest;
    }

    //finds the index of the song we want. An array of indices for if there are copies.
    public int[] selectIndex (String[] playlist, String song) {
        Duplicates = 0;
        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i] == song) {
                this.selectindex[Duplicates] = i;
                Duplicates++;
            }
        }
        return selectindex;
    }
}