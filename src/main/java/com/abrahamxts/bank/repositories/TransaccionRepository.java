package com.abrahamxts.bank.repositories;

import com.abrahamxts.bank.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<TransaccionModel, String> {}
