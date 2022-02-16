
package com.simpl.paylater.repository;

import com.simpl.paylater.model.Merchant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Merchant dao.
 */
@Repository
public interface MerchantRepository extends JpaRepository<Merchant, String> {
}
