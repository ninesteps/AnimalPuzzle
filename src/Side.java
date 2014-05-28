class Side {
	char colour;
	boolean isHead;
	boolean isDeasil;


    public Side(String side){
        colour = side.charAt(0);
        isHead = (side.charAt(1)=='H');
        isDeasil = (side.charAt(2)=='C');
    }

	public String toString() {
		return "" + colour + (isHead ? "H" : "T") + (isDeasil ? "C" : "A");
	}
	public boolean equals(Object other) {
		if (other == null) return true;
        if (!(other instanceof Side)) return false;
		Side o = (Side)other;
		return o.colour == colour && !(o.isHead == isHead) && !(o.isDeasil == isDeasil);
	
	}
}
