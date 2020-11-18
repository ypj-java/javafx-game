package model;

public class Snake {

    private int hX = 0;

    private int hY = 0;

    private int len = 4;

    private char c = 'd';

    private final int[] map;

    private final int size;

    public Snake(int size){
        this.size = size;
        map = new int[size*size];
        map[(int)(Math.random()*size*size)] = -1;
    }

    public int getSize(){
        return size;
    }

    public int[] snake(){
        return this.snake(c);
    }

    public int[] snake(char cl){
        cl = Character.toLowerCase(cl);
        if (cl == 'a'&&c != 'd' || cl == 'd'&&c != 'a' ||
                cl == 'w'&&c != 's' || cl == 's'&&c != 'w')c = cl;

        if (c == 'a'&&--hX < 0 || c == 'd'&&++hX == size ||
                c == 'w'&&--hY < 0 || c == 's'&&++hY == size)return null;

        if (map[hY * size + hX] != 0)
            if ((map[hY * size + hX] > 0 ? -1 : ++len) < 0) return null;
            else
                for (int i = (int)(Math.random()*size*size) % size*size; map[i]!=0 || (map[i] = -1)==0; i = (int)(Math.random()*size*size) % size*size);
        else for (int i = 0; i < size*size; i++) {
            if (map[i] > 0) {
                map[i] -= 1;
            }
        }
        map[hY * size + hX] = len;
        return map;
    }

}
