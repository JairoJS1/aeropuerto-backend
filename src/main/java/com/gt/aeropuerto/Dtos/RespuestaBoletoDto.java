/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.aeropuerto.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author JairoJS
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaBoletoDto {
    private String numeroBoleto;
    private Integer idBoleto;
}
