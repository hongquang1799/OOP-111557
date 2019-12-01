package data;

public class City extends Entity {
	private String nation;

	public City() {

	}

	public City(String id, String name, String description, String nation) {
		super(id, name, description);

		this.setNation(nation);
	}

	public City(City copy) {
		super(copy);

		nation = copy.nation;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
}
