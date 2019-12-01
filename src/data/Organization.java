package data;

public class Organization extends Entity {
	private String nation;

	public Organization() {

	}

	public Organization(String id, String name, String description, String nation) {
		super(id, name, description);
		this.setNation(nation);
	}

	public Organization(Organization copy) {
		super(copy);

		nation = copy.nation;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
}
