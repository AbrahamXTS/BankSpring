package com.abrahamxts.bank.utils;

import lombok.*;

@Data
@AllArgsConstructor
public class WrapperResponse<T> {
	private Boolean ok;
	private String message;
	private T body;
}
