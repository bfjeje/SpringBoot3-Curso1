package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DatosListaMedico;
import med.voll.api.medico.DatosRegistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroMedico datos) {
        repository.save(new Medico(datos));
    }

    @GetMapping
    public Page<DatosListaMedico> listar(Pageable paginacion) {
        return repository.findAll(paginacion).map(DatosListaMedico::new);
    }
}
