package poo.intermediate.genericTypes.useE;

import java.util.Objects;

public class Processing<T>{

	private T value;

	public void setProcessing(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processing<?> other = (Processing<?>) obj;
		return Objects.equals(value, other.value);
	}
	
	

}
