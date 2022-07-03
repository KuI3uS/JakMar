package pl.pjatk.JakMar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nbp")
public class JakMarApplication {
	final NBPService nbpService;

	public JakMarApplication(NBPService nbpService) {
		this.nbpService = nbpService;
	}

	@GetMapping("/waluta/{code}/{waluta}/{startDate}/{endDate}")
	public NBPEntity all(@PathVariable String code, @PathVariable String waluta, @PathVariable  String startDate, @PathVariable String endDate){
		return nbpService.getWaluta(code,waluta,startDate,endDate);
	}
	@GetMapping("/zloto")
	public String all2(){
		return nbpService.getZloto();
	}

}
