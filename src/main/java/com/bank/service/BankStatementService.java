package com.bank.service;

import java.time.LocalDate;
import java.util.List;

import com.bank.dto.BankStatementDto;

public interface BankStatementService {

	public List<BankStatementDto> getBankStatement(String timePeriod,String userAccout);
}
