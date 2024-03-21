package com.deloitte.shoppingcart.idgenerator;

import java.util.Random;



import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdGenerator implements IdentifierGenerator  {

	@Override
	public Object generate(SharedSessionContractImplementor si, Object object) {
		Random random = null;
		int id = 0;
		random = new Random();
		id = random.nextInt(1000000);
		return id;
	
	}

}
