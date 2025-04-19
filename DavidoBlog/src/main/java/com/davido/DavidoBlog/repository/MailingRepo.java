package com.davido.DavidoBlog.repository;

import com.davido.DavidoBlog.model.MailingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailingRepo extends JpaRepository<MailingList, Long> {
}
