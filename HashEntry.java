public class HashEntry<K, V>{
	public K key;
	public V value;
	public int dIB;
	public HashEntry(K key, V value, int dIB) {
		super();
		this.key = key;
		this.value = value;
		this.dIB = dIB;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public int getdIB() {
		return dIB;
	}
	public void setdIB(int dIB) {
		this.dIB = dIB;
	}
	
    /*private String key;
    private int value, DIB;
    HashEntry(String key, int value, int DIB) {
          this.key = key;
          this.value = value;
          this.DIB = DIB;
    }     
    public String getKey() {return key;}
    public int getValue() {return value;}
    public int getDIB() {return DIB;}
	public void setKey(String key) {this.key = key;}
	public void setValue(int value) {this.value = value;}
	public void setDIB(int dIB) {DIB = dIB;}*/
	
    
}
