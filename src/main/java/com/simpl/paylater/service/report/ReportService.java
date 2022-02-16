package com.simpl.paylater.service.report;

import com.simpl.paylater.dto.ReportMerchantDiscountRequest;
import com.simpl.paylater.dto.ReportUserDuesRequest;
import com.simpl.paylater.model.User;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ReportService {

  double discountProvidedMerchant(ReportMerchantDiscountRequest request);

  double userDues(ReportUserDuesRequest request);

  List<User> userAtCreditLimit();

  List<User> allUserDues();
}
