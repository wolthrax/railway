//package railway.services;
//
//import java.beans.PropertyVetoException;
//import java.sql.SQLException;
//
//import railway.dba.dao.user.IUserDao;
//import railway.dba.dao.user.UserDaoImpl;
//import railway.entities.Schedule;
//import railway.entities.Train;
//import railway.entities.User;
//import railway.entities.models.Credential;
//import railway.services.train.ITrainManager;
//import railway.services.train.TrainManagerImpl;
//import railway.services.user.IUserManager;
//import railway.services.user.UserManagerImpl;
//
//public class Main {
//
//	public static void main(String[] args) throws SQLException, PropertyVetoException {
//		
//		
//		IUserManager u = new UserManagerImpl();
//		Credential credential = new Credential("qweqwe", "qweqwe");
//		User users = u.authentication(credential);
//		System.out.println(users);
//		
//		IUserManager u2 = new UserManagerImpl();
//		credential = new Credential("Efimka", "8814281");
//		User users2 = u2.authentication(credential);
//		System.out.println(users2);
//		
//
////		IBaseDao<User, Long> dao = new UserDaoImpl();
////		User user = new User();
////		user.setId(2L);
////		user.setLogin("Efimka");
////		user.setPassword("8814281");
////		user.setName("Efim");
////		user.setSurname("Grygoryev");
////		user.setEmail("efimka@gmail.com");
////		user.setPhone("8813481");
////		user.setRole(UserRole.ADMIN);
////		user.setMoney(1000);
////		dao.update(user);
////		//System.out.println(dao.update(user));
//		
////		IBaseDao<Station, Long> dao = new StationDaoImpl();
////		Station s = new Station();
////		s.setName("Minsk");
////		
////		dao.add(s);
//		
//		
////		IBaseDao<Schedule, Long> scheduleDao = new ScheduleDaoImpl();
////		
////		Schedule schedule = new Schedule();
////		schedule.setDepatureTime("2016-12-12 22:30");
////		schedule.setArrivalTime("2016-12-12 23:30");
////		schedule.setDepatureStation(2);
////		schedule.setArrivalStation(1);
////		
////		long scheduleId = scheduleDao.add(schedule);
////		
////		
//		ITrainManager m = new TrainManagerImpl();
//		
//		Schedule schedule = new Schedule();
//		Train train = new Train();
//		schedule.setDepatureTime("2016-11-12 22:30");
//		schedule.setArrivalTime("2016-11-12 23:30");
//		schedule.setDepatureStation(String.valueOf(1));
//		schedule.setArrivalStation(String.valueOf(3));
//		train.setPlaces(100);
//		train.setPrice(34.34);
//		train.setSchedule(schedule);
//		
//		m.addTrain(train);
//		//System.out.println("Created train with id: " + trainId);
//		
//		
////		SiutableScheduleModel s = new SiutableScheduleModel();
////		
////		s.setDepatureTime("2016-12-12 12:30");
////		s.setDepatureStation("2");
////		s.setArrivalStation("1");
////		
////		System.out.println(trainDao.getSiutableTrains(s));
//		
//		
//		//System.out.println(dao.getAll());
//	}
//}
