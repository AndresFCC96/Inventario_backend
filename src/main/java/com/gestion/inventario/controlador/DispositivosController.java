package com.gestion.inventario.controlador;

import com.gestion.inventario.dominio.Dispositivo;
import com.gestion.inventario.dto.DispositivoDto;
import com.gestion.inventario.repositorio.DispositivoRepository;
import com.gestion.inventario.servicio.DispositivoService;
import com.gestion.inventario.utils.GeneradorCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventario/devices")
public class DispositivosController {

    @Autowired
    private GeneradorCSV generateCsv;

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private DispositivoService dispositivoService;

    @GetMapping("/devices")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listAllDevices() throws Exception {
        return ResponseEntity.ok().body(dispositivoService.listarTodosLosDispositivos());
    }

    @GetMapping("/finddevicebyname")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findDeviceByName(@RequestParam("name") String name) throws Exception {
        return ResponseEntity.ok().body(dispositivoService.encontrarDispositivoPorNombre(name));
    }

    @GetMapping("/finddevicebymodel")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findDeviceByModel(@RequestParam("model") String model) throws Exception {
        return ResponseEntity.ok().body(dispositivoService.encontrarDispositivoPorModelo(model));
    }

    @GetMapping("/finddevicebyinventaryslot")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findDeviceByInventarySlot(@RequestParam("numero") Long numero) throws Exception {
        return ResponseEntity.ok().body(dispositivoService.encontrarDispositivoPorNumeroDeInventario(numero));
    }

    @GetMapping("/finddevicebyserialnumber")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findDeviceBySerialNumber(@RequestParam("numero") String numero) throws Exception {
        return ResponseEntity.ok().body(dispositivoService.encontrarDispositivoPorNumeroDeSerie(numero));
    }

    @PostMapping("/createdevice")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createNewDevice(@RequestBody DispositivoDto dispositivoDto) throws Exception {
        return ResponseEntity.ok().body(dispositivoService.guardarDispositivo(dispositivoDto));
    }

    @PutMapping("/modifydevice")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> modifyADevice(@RequestBody DispositivoDto dispositivoDto) throws Exception {
        return ResponseEntity.ok().body(dispositivoService.modificarDispositivo(dispositivoDto));
    }

    @DeleteMapping("/deletedevice")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteDevice(@RequestBody DispositivoDto dispositivoDto){
        return ResponseEntity.ok().body(dispositivoService.eliminarDispositivo(dispositivoDto));
    }

    @GetMapping("/csv")
    public ResponseEntity<byte[]> generateCsvFile() {
        List<Dispositivo> dispositivos = dispositivoRepository.findAll();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "employees.csv");

        byte[] csvBytes = generateCsv.generarCsv(dispositivos).getBytes();

        return new ResponseEntity<>(csvBytes, headers, HttpStatus.OK);
    }
}
