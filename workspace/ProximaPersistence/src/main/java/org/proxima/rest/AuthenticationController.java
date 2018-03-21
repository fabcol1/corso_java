/**
 * 
 */
package org.proxima.rest;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maurizio
 *
 */
@RestController
public class AuthenticationController {
        @RequestMapping("/user")
        public Principal user(Principal user) {
                return user;
        }
}