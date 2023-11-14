package customerManagementSystem.core;

public enum ServicePlan {
	SILVER(1000), GOLD(2000), DIAMOND(5000), PLATINUM(10000);
	
	private int additionalCost;
	
	private ServicePlan(int additionalCost) {
		this.additionalCost = additionalCost;
	}
	public int getAdditionalCost() {
		return additionalCost;
	}
	 public void setAdditionalCost(int additionalCost) {
		 this.additionalCost = additionalCost;
	 }
	 
	 @Override
	 public String toString() {
		 return name();
	 }
	
}	
