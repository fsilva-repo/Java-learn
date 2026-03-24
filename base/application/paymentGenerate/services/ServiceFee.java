package poo.base.application.paymentGenerate.services;

import java.util.List;

public interface ServiceFee {
	List<Double> toGenerate(double contractValue, int installmentQuantity);
}
