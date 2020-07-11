import database.Slip;
import database.SlipDao;
import http.SlipDto;
import http.SlipResponse;
import http.HttpClient;

import java.util.List;

public class AdviceService {
    private static final String URL = "https://api.adviceslip.com/";
    private final HttpClient httpClient = new HttpClient();

    public SlipDto getRandomAdvice() {
        return httpClient.fetch(URL + "advice", SlipResponse.class).getSlip();
    }

    public void saveAdvise(SlipDto slip) {
        Slip slipToSave = new Slip(slip);
        SlipDao slipDao = new SlipDao();
        slipDao.insertOrUpdate(slipToSave);
    }

    public List<Slip> getAllAdvice() {
        SlipDao slipDao = new SlipDao();
        List<Slip> slips = slipDao.getAll();
        return slips;
    }


    public boolean deleteID(Long slipId) {
        SlipDao slipDao = new SlipDao();
        if (slipDao.deleteSlip(slipId)) {
            return true;
        }
        return false;
    }
}


