package benchmark;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

import data.*;
import database.*;
import util.*;

public class DataGenerator {

	enum EntityType {
		PERSON, CITY, ORGANIZATION, EVENT, AGREEMENT
	}

	enum FactType {
		GAP_GO, TO_CHUC, KY_THOA_THUAN, THAM_GIA, DIEN_RA_TAI, UNG_HO, PHAN_DOI, PHAT_BIEU_TAI, CANG_THANG_VOI, HUY_BO,
		DAM_PHAN_VOI
	}

	static HashMap<EntityType, ArrayList<Entity>> DATA_SAMPLES = new HashMap<EntityType, ArrayList<Entity>>();

	private static void GenerateSampleData() {
		DATA_SAMPLES.clear();

		ArrayList<Entity> personSamples = new ArrayList<Entity>();
		personSamples.add(new Person("", "Obama", " tổng thống thứ 44 của Hoa Kỳ từ năm 2009 đến năm 2017. Ông là người Mỹ gốc Phi đầu tiên được bầu vào chức vụ này", "6-2-1955", "US"));
		personSamples.add(new Person("", "Nguyen Phu Trong", "một chính trị gia người Việt Nam. Ông hiện là Chủ tịch nước Cộng hòa xã hội chủ nghĩa Việt Nam, Đại biểu Quốc hội Việt Nam khóa XIV nhiệm kì 2016–2021", "8-2-1955", "VN"));
		personSamples.add(new Person("", "Putin", "là một chính trị gia người Nga và là cựu Thủ tướng của Liên bang Nga, là Tổng thống thứ hai của Nga từ 7 tháng 5 năm 2000 cho đến 7 tháng 5 năm 2008, là Tổng thống thứ tư của Nga", "1-8-1955", "RS"));
		personSamples.add(new Person("", "Tap Can Binh", " là nhà lãnh đạo quốc gia tối cao của Trung Quốc. Ông hiện là Tổng Bí thư Ủy ban Trung ương Đảng Cộng sản Trung Quốc", "10-2-1955", "CN"));
		DATA_SAMPLES.put(EntityType.PERSON, personSamples);

		ArrayList<Entity> citySamples = new ArrayList<Entity>();
		citySamples.add(new City("", "Ha Noi", "Hà Nội là thủ đô của nước Cộng hòa Xã hội chủ nghĩa Việt Nam, cũng là kinh đô của hầu hết các vương triều phong kiến tại Việt Nam trước đây", "VN"));
		citySamples.add(new City("", "Da nang", "Đà Nẵng là một thành phố trực thuộc trung ương, nằm trong vùng Duyên hải Nam Trung Bộ Việt Nam, là trung tâm kinh tế, chính trị, du lịch, giáo dục - đào tạo, y tế, khoa học - công nghệ, công nghệ thông tin của Miền Trung", "VN"));
		citySamples.add(new City("", "New York", "Nằm trên một bến cảng tự nhiên lớn thuộc duyên hải Đại Tây Dương của Đông Bắc Hoa Kỳ, thành phố gồm có năm quận: The Bronx, Brooklyn, Manhattan, Queens, và Đảo Staten", "US"));
		citySamples.add(new City("", "Beijing", "Bắc Kinh là thành phố lớn thứ hai của Trung Quốc nếu xét theo dân số đô thị, xếp sau Thượng Hải, là một trong số các thành phố đông dân nhất thế giới với dân số là 21,707,000 người vào năm 2017.; và là trung tâm chính trị, văn hóa và giáo dục của Trung Quốc", "CN"));
		DATA_SAMPLES.put(EntityType.CITY, citySamples);

		ArrayList<Entity> orgSamples = new ArrayList<Entity>();
		orgSamples.add(new Organization("", "Apple", "Apple Inc. là một tập đoàn công nghệ máy tính của Mỹ có trụ sở chính đặt tại Cupertino, California. Apple được thành lập ngày 1 tháng 4 năm 1976 dưới tên Apple Computer, Inc., và đổi tên thành Apple Inc. vào đầu năm 2007.", "US"));
		orgSamples.add(new Organization("", "Viettel", "Viettel Group (full name in Vietnamese: Tập đoàn Công nghiệp Viễn thông Quân đội, lit. 'Army Telecommunication Industry Corporation') is Vietnam's largest mobile network operator. It is a state-owned enterprise wholly owned and operated by the Ministry of Defence.", "VN"));
		orgSamples.add(new Organization("", "Huawei", "Huawei được thành lập năm 1987 bởi Nhậm Chính Phi, một cựu kỹ sư của Giải phóng quân Nhân dân Trung Quốc.", "CN"));
		DATA_SAMPLES.put(EntityType.ORGANIZATION, orgSamples);

		ArrayList<Entity> eventSamples = new ArrayList<Entity>();
		eventSamples.add(new Event("", "Trinh dien phao hoa quoc te", "Nhằm tạo không khí vui tươi, phấn khởi trong người dân thành phố Đà Nẵng và thời khắc Giao thừa Tết Nguyên đán Kỷ Hợi 2018"));
		eventSamples.add(new Event("", "Vong chung ket quoc thi nguoi mau", "Ngũ Hành Sơn có xuất xứ từ một lễ vía thuần túy tôn giáo của đồng bào theo đạo Phật"));
		eventSamples.add(new Event("", "Diem hen mua he", "Chương trình “Đà Nẵng – Điểm hẹn mùa hè 2019” được tổ chức định kỳ hàng năm nhằm góp phần tạo nên chuỗi sự kiện thu hút khách du lịch đến với Đà Nẵng."));
		eventSamples.add(new Event("", "Chay marathon quoc te", "Với những sự kiện đặc sắc, tầm cỡ, năm 2019 hứa hẹn là một năm mang đến cho du lịch Đà Nẵng một năm để lại nhiều dấu ấn với du khách trong và ngoài nước."));
		eventSamples.add(new Event("", "Cuoc thi boi loi vo dich chau A", "Tiếp nối thành công của những cuộc thi của các năm trước, Ironman 70.3 tiếp tục là sự kiện được sự quan tâm lớn của các vận động viên, người dân và du khách đến với thành phố Đà Nẵng."));
		DATA_SAMPLES.put(EntityType.EVENT, eventSamples);

		ArrayList<Entity> agreementSamples = new ArrayList<Entity>();
		agreementSamples.add(new Agreement("", "Thoa thuan chuyen giao cong nghe VN-US", "Khong co mieu ta"));
		agreementSamples.add(new Agreement("", "Thoa thuan hop tac phat trien VN-US", "Khong co mieu ta"));
		agreementSamples.add(new Agreement("", "Thoa thuan hop tac phat trien VN-CN", "Khong co mieu ta"));
		agreementSamples.add(new Agreement("", "Thoa thuan thuong mai tu do chau A", "Khong co mieu ta"));
		DATA_SAMPLES.put(EntityType.AGREEMENT, agreementSamples);
	}

	public static void Generate(int entityTotalCount, int entityBatchCount, int factTotalCount, int factBatchCount,
			IDatabaseManager database, String dbName, String entityCltName, String factCltName) {

		GenerateSampleData();

		ArrayList<Entity> personList = new ArrayList<Entity>();
		ArrayList<Entity> cityList = new ArrayList<Entity>();
		ArrayList<Entity> organizationList = new ArrayList<Entity>();
		ArrayList<Entity> eventList = new ArrayList<Entity>();
		ArrayList<Entity> agreementList = new ArrayList<Entity>();

		ArrayList<Entity> entityBatch = new ArrayList<Entity>();
		ArrayList<Fact> factBatch = new ArrayList<Fact>();

		int factBatchLastIndex = 0;
		int entityBatchLastIndex = 0;

		for (int i = 0; i < entityTotalCount;) {
			entityBatchLastIndex = Math.min(entityBatchLastIndex + entityBatchCount, entityTotalCount);

			for (; i < entityBatchLastIndex; i++) {
				int type = AppUtility.Random(5);
				Entity clone = AppUtility.GetRandomEntityFromArray(DATA_SAMPLES.get(EntityType.values()[type]));
				Entity entity = null;

				switch (EntityType.values()[type]) {
				case PERSON:
					entity = new Person((Person) clone);
					entity.setId("PERSON" + String.valueOf(personList.size()));
					personList.add(entity);
					break;
				case CITY:
					entity = new City((City) clone);
					entity.setId("CITY" + String.valueOf(cityList.size()));
					cityList.add(entity);
					break;
				case ORGANIZATION:
					entity = new Organization((Organization) clone);
					entity.setId("ORGANIZATION" + String.valueOf(organizationList.size()));
					organizationList.add(entity);
					break;
				case EVENT:
					entity = new Event((Event) clone);
					entity.setId("EVENT" + String.valueOf(eventList.size()));
					eventList.add(entity);
					break;
				case AGREEMENT:
					entity = new Agreement((Agreement) clone);
					entity.setId("AGREEMENT" + String.valueOf(agreementList.size()));
					agreementList.add(entity);
					break;
				}

				entityBatch.add(entity);
			}

			database.createDocument(dbName, entityCltName, entityBatch);
			entityBatch.clear();
		}

		for (int i = 0; i < factTotalCount;) {
			factBatchLastIndex = Math.min(factBatchLastIndex + factBatchCount, factTotalCount);
			
			for (; i < factBatchLastIndex; i++) {
				int type = AppUtility.Random(10);
				Entity object = null;
				Entity subject = null;

				switch (FactType.values()[type]) {

				case GAP_GO:
					subject = AppUtility.GetRandomEntityFromMutipleArray(null, personList);
					object = AppUtility.GetRandomEntityFromMutipleArray(subject, personList);
					break;
				case TO_CHUC:
					subject = AppUtility.GetRandomEntityFromMutipleArray(null, organizationList, personList);
					object = AppUtility.GetRandomEntityFromMutipleArray(subject, eventList);
					break;
				case KY_THOA_THUAN:
					subject = AppUtility.GetRandomEntityFromMutipleArray(null, organizationList);
					object = AppUtility.GetRandomEntityFromMutipleArray(subject, organizationList);
					break;
				case THAM_GIA:
					subject = AppUtility.GetRandomEntityFromMutipleArray(null, personList, organizationList);
					object = AppUtility.GetRandomEntityFromMutipleArray(subject, organizationList, eventList,
							agreementList);
					break;
				case DIEN_RA_TAI:
					subject = AppUtility.GetRandomEntityFromMutipleArray(null, eventList);
					object = AppUtility.GetRandomEntityFromMutipleArray(subject, cityList, organizationList);
					break;
				case UNG_HO:
					subject = AppUtility.GetRandomEntityFromMutipleArray(null, personList, organizationList);
					object = AppUtility.GetRandomEntityFromMutipleArray(subject, organizationList, agreementList,
							eventList);
					break;
				case PHAN_DOI:
					subject = AppUtility.GetRandomEntityFromMutipleArray(null, personList, organizationList);
					object = AppUtility.GetRandomEntityFromMutipleArray(subject, organizationList, agreementList,
							eventList);
					break;
				case PHAT_BIEU_TAI:
					subject = AppUtility.GetRandomEntityFromMutipleArray(null, personList);
					object = AppUtility.GetRandomEntityFromMutipleArray(subject, eventList);
					break;
				case CANG_THANG_VOI:
					subject = AppUtility.GetRandomEntityFromMutipleArray(null, organizationList);
					object = AppUtility.GetRandomEntityFromMutipleArray(subject, organizationList);
					break;
				case HUY_BO:
					subject = AppUtility.GetRandomEntityFromMutipleArray(null, personList, organizationList);
					object = AppUtility.GetRandomEntityFromMutipleArray(subject, agreementList, eventList);
					break;
				case DAM_PHAN_VOI:
					subject = AppUtility.GetRandomEntityFromMutipleArray(null, organizationList);
					object = AppUtility.GetRandomEntityFromMutipleArray(subject, organizationList);
					break;
				default:
					break;
				}

				if (subject != null && object != null) {
					// create a fact
					String factID = "FACT" + String.valueOf(i);
					String date = AppUtility.RandomDate(2010, 2018);

					Fact fact = new Fact();
					fact.setId(factID);
					fact.setObjectID(object.getId());
					fact.setSubjectID(subject.getId());
					fact.setDate(date);
					fact.setRelationship(FactType.values()[type].toString());

					factBatch.add(fact);
				} else {
					i--;
				}
			}
			database.createDocument(dbName, "facts", factBatch);
			factBatch.clear();
		}
	}
}
