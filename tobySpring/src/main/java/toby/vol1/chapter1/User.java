package toby.vol1.chapter1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class User {
	private String id;
	private String name;
	private String password;
}
