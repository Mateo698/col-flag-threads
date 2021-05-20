package model;

public class StripeProgress {
	
	private int rowsAmount;
	private int time;
	private String fill;
	private String[] rows;
	private int current;
	
	public StripeProgress(int rows, String fill) {
		this.setRowsAmount(rows);
		this.fill = fill;
		this.rows = new String[rows];
		current = 1;
		create();
	}
	
	public void create() {
		for (int i = 0; i < rows.length; i++) {
			rows[i] =  fill;
		}
		current = 2;
	}

	public void advance() {
		boolean advanced = false;
		for (int i = 0; i < rows.length && !advanced; i++) {
			if(rows[i].length() < current+6) {
				rows[i] += " ";
				advanced = true;
			}
		}
		if(!advanced) {
			current++;
			for (int i = 0; i < rows.length && !advanced; i++) {
				if(rows[i].length() < current+6) {
					rows[i] += " ";
					advanced = true;
				}
			}
		}
	}
	
	
	public String getStatus() {
		String status = "";
		for (int i = 0; i < rows.length; i++) {
			status += rows[i] + "\u001b[m\r\n";
		}
		return status;
	}
	
	
	public boolean finished() {
		if(rows[rows.length-1].length() < 100) {
			return false;
		}else {
			return true;
		}
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getRowsAmount() {
		return rowsAmount;
	}

	public void setRowsAmount(int rowsAmount) {
		this.rowsAmount = rowsAmount;
	}

	
	
}
