/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridtest;

import static data.helpers.Artist.DrawQuadTexture;

/**
 *
 * @author Keith
 */
public class TileGrid {
    
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 15;
    
    private int tilesWide;
    private int tilesHigh;
    
    public Tile[][] map;
    
    // Makes alternating strips of two tile types.
 /*   public TileGrid()
    {
        map = new Tile[20][15];
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map[i].length; j++)
            {
                if(i % 2 == 0)
                {
                    map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Earth);
                }
                else
                {
                    map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Veg);
                }
            }
        }
    }  */
    
    
    public TileGrid()
    {
        map = new Tile[20][15];
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[i].length; j++)
            {
                map[i][j] = new Tile(i * 64, j *  64, 64, 64, TileType.Veg);
            }
        }
    }
    
    public TileGrid(int[][] newMap)
    {
        this.tilesWide = newMap[0].length;  // need these to check that we aren't going off the map.
        this.tilesHigh = newMap.length;
        
        map = new Tile[tilesWide][tilesHigh];
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map[i].length; j++)
            {
    /*            if (newMap[j][i] == 0)
                    map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Veg);
                else if (newMap[j][i] == 1)
                    map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Earth);
                else if (newMap[j][i] == 2)
                    map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Water);
    */            
                switch(newMap[j][i])
                {
                    case 0:
                        map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Veg);
                        break;
                    case 1:
                        map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Earth);
                        break;
                    case 2:
                        map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Water);
                        break;
                }        
            }
        }
    }
    
    // Sets a tile of a specific type in a specified location.
    public void SetTile(int xCoord, int yCoord, TileType type) 
    {
        map[xCoord][yCoord] = new Tile(xCoord * 64, yCoord * 64, 64, 64, type);
    }
    
    
    // Returns information for the tile at the specified location.
    public Tile GetTile(int xPlace, int yPlace)
    {
        if(xPlace < getTilesWide() && yPlace < getTilesHigh() && xPlace > -1 && yPlace > -1)
        {
            return map[xPlace][yPlace];
        }
        else
            return new Tile(0, 0, 0, 0, TileType.NULL);
    }
    
    
    
    public void Draw()
    {
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[i].length; j++)
            {
                map[i][j].Draw();
//                Tile t = map[i][j];
//                DrawQuadTexture(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHeight());
            }
        }
    }

    /**
     * @return the tilesWide
     */
    public int getTilesWide() {
        return tilesWide;
    }

    /**
     * @param tilesWide the tilesWide to set
     */
    public void setTilesWide(int tilesWide) {
        this.tilesWide = tilesWide;
    }

    /**
     * @return the tilesHigh
     */
    public int getTilesHigh() {
        return tilesHigh;
    }

    /**
     * @param tilesHigh the tilesHigh to set
     */
    public void setTilesHigh(int tilesHigh) {
        this.tilesHigh = tilesHigh;
    }
}
