import java.util.ArrayList;

/*
 This class contains the map of the maze and all pokemons and stations
 */
public class Map {
	//an 2D array of Location objects,used to stored Pokemon,Station,Wall,Empty and Destination
	//index is the location of the object in the map
	private Location[][] map = null;
	//the start location of the map(i.e. 'S' in the map)
	private Location start = null;
	//max row and column of the map
	private int max_row;
	private int max_column;
	
	//used to store the pokemons in the map,mainly used to construct map
	private ArrayList<Pokemon> pokemons = null;
	private ArrayList<Station> stations = null;
	
	public Map(int max_row,int max_column){
		this.max_column = max_column;
		this.max_row = max_row;
		map = new Location[max_row][max_column];
		pokemons = new ArrayList<>();
		stations = new ArrayList<>();
	}
	
	public void addPokemon(Pokemon pokemon){
		pokemons.add(pokemon);
	}
	
	public void addStation(Station station){
		stations.add(station);
	}
	
	//get all the pokemons in the map
	public ArrayList<Pokemon> getPokemons(){
		return pokemons;
	}
	
	//get all the stations in the map
	public ArrayList<Station> getStaion(){
		return stations;
	}
	
	//when construct the map,this function is used to record the start location
	public void setStartLocation(Location start){
		this.start = start;
	}
	
	//mainly used to create new player,set players current location to start location
	public Location getStartLocation(){
		return this.start;
	}
	
	//mainly used to construction map one element by one element
	public void setMapElement(Location element){
		map[element.getRow()][element.getColumn()] = element;
	}
	
	//check whether a given location is out of bound
	//mainly used to test whether the player`s current location is outside the map
	public boolean isOutOfBound(int row,int column){
		if(row < 0 || column < 0 || row >= this.max_row || column >= this.max_column)
			return true;
		return false;	
	}
	
	//get the element of the map in given location
	//mainly used to get pokemon and station object in the map
	public Location getMapElement(int row, int column){
		return map[row][column];
	}
	
}
