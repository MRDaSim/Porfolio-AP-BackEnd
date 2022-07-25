
package com.portfolio.mrd.security.service;

import com.portfolio.mrd.security.entity.Usuario;
import com.portfolio.mrd.security.repository.IUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
        @Autowired
        IUsuarioRepository iusuarioRepository;
        
        public Optional <Usuario> getByNombreUsuario (String nombreUsuario) {
            return iusuarioRepository.findByNombreUsuario(nombreUsuario);
        }
        
        public boolean exitsByNombreUsuario (String nombreUsuario) {
            return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
        }
        
        public boolean exitsByEmail (String email) {
            return iusuarioRepository.existsByNombreUsuario(email);
        }
        
        public void save (Usuario usuario) {
            iusuarioRepository.save(usuario);
        }
}
