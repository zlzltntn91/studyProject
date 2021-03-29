import hash.ChainHash;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class HashTest {

	@Test
	public void hash(){
		ChainHash<Integer, Integer> chainHash = new ChainHash<>(13);
		log.debug(chainHash.add(3, 2) + "");
		log.debug(chainHash.add(16, 2) + "");
		log.debug(chainHash.add(29, 2) + "");
		log.debug(chainHash.remove(16) + "");
		log.debug(chainHash.add(42, 2) + "");
		log.debug(chainHash.add(55, 2) + "");
		log.debug(chainHash.toString());
		chainHash.dump();
	}
}
