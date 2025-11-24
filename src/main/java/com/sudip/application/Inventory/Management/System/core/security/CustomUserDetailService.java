package com.sudip.application.Inventory.Management.System.core.security;

import com.sudip.application.Inventory.Management.System.entity.Supplier;
import com.sudip.application.Inventory.Management.System.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CustomUserDetailService implements UserDetailsService {


        @Autowired
        private SupplierRepository supplierRepository;

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            Supplier supplier = supplierRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));

            return org.springframework.security.core.userdetails.User
                    .withUsername(supplier.getEmail())
                    .password(supplier.getPassword())
                    .authorities("ROLE_" + supplier.getRole())
                    .build();
        }
    }

