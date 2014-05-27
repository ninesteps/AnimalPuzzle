class Side {
	char colour;
	boolean isHead;
	boolean isDeasil;
	public String toString() {
		return "" + colour + (isHead ? "H" : "T") + (isDeasil ? "C" : "A");
	}
	public boolean equals(Object other) {
		if (other == null || !(other instanceof Side)) return false;
		Side o = (Side)other;
		return o.colour == colour && o.isHead == isHead && o.isDeasil == isDeasil;
	}
}
