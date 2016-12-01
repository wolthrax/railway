package railway.web.timers;

import railway.services.train.ITrainManager;
import railway.services.train.TrainManagerImpl;
import railway.utils.logger.RailwayLogger;

public class DeleteTimerTrains implements Runnable{
	
	private int sec;
	
	public DeleteTimerTrains(int sec) {
		this.sec = sec;
	}

	@Override
	public void run() {
		ITrainManager trainManager = new TrainManagerImpl();
		while(true){
            for(int i = 0; i < sec; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                   RailwayLogger.logError(getClass(), e.getMessage());
                }
            }
            trainManager.deleteTrains();
        }
	}
}
