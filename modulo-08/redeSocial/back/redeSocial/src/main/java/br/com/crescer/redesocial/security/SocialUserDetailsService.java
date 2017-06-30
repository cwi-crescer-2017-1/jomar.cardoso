package br.com.crescer.redesocial.security;

import br.com.crescer.redesocial.models.Usuario;
import br.com.crescer.redesocial.services.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jomar
 */
@Service
public class SocialUserDetailsService implements UserDetailsService {
    
    @Autowired
    UsuarioService usuarioService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final List<GrantedAuthority> grants = new ArrayList<>();
        Usuario usuario = usuarioService.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("");
        }
        return new User(username, usuario.getSenha(), grants);
    }
}
