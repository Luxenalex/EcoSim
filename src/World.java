import Terrain.Terrain;

import java.util.ArrayList;

public class World {

    int tileSize;
    int numOfTilesWidth;
    int getNumOfTilesHeight;
    ArrayList<Terrain> terrainTiles;

    public World(int tileSize, int numOfTilesWidth){
        this.tileSize = tileSize;
        this.numOfTilesWidth = numOfTilesWidth;
        terrainTiles = new ArrayList<>();
    }

    public void addTerrainTile(Terrain terrain){
        terrainTiles.add(terrain);
    }


}
