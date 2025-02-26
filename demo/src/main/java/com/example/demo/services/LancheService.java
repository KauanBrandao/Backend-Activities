package com.example.demo.services;

import com.example.demo.entities.Lanche;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Classe responsável por gerenciar o armazenamento e manipulação das imagens dos lanches.
 * Faz parte da camada de serviço (Service Layer), lidando com operações de arquivos.
 */
public class LancheService {
    // Caminho onde as imagens dos lanches serão armazenadas
    private String filePath = "C:\\Users\\aluno.fsa\\ImagensLancheDestino\\";

    /**
     * Obtém um lanche pelo seu ID (não implementado ainda)
     */
    public Lanche getById(int id) {
        return null;
    }

    /**
     * Verifica se um lanche existe pelo seu ID (sempre retorna true no momento, precisa ser implementado corretamente)
     */
    public boolean exists(int id) {
        return true;
    }

    /**
     * Obtém a extensão do arquivo de imagem
     */
    private String getFileExtension(Path path) {
        String filename = path.getFileName().toString();
        int lastDotIndex = filename.lastIndexOf('.');

        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return ""; // Sem extensão
        }

        return filename.substring(lastDotIndex + 1);
    }

    /**
     * Salva a imagem do lanche no diretório especificado
     */
    public boolean salvar(Lanche lanche) {
        Path path = Paths.get(lanche.getImagem()); // Obtém o caminho original da imagem
        Path destinationPath = Paths.get(String.format("%s%d.%s", filePath, lanche.getCodigo(), getFileExtension(path)));

        if (Files.exists(path)) { // Verifica se o arquivo de imagem realmente existe
            try {
                Files.copy(path, destinationPath, StandardCopyOption.REPLACE_EXISTING); // Copia a imagem para o destino
                lanche.setImagem(destinationPath.toString()); // Atualiza a referência da imagem
                return true;
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }

    /**
     * Exclui a imagem do lanche ao removê-lo do sistema
     */
    public void excluir(int id, Lanche lanche) {
        if (lanche != null && lanche.getImagem() != null) {
            try {
                Files.deleteIfExists(Paths.get(lanche.getImagem())); // Remove o arquivo de imagem
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Atualiza a imagem de um lanche
     */
    public void atualizar(int id, Lanche lanche) {
        if (lanche != null && lanche.getImagem() != null) {
            Lanche lancheExistente = getById(id);
            if (lancheExistente != null && lancheExistente.getImagem() != null) {
                try {
                    Files.deleteIfExists(Paths.get(lancheExistente.getImagem())); // Remove a imagem antiga
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Path path = Paths.get(lanche.getImagem());
            Path destinationPath = Paths.get(String.format("%s%d.%s", filePath, lanche.getCodigo(), getFileExtension(path)));

            try {
                Files.copy(path, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                lanche.setImagem(destinationPath.toString()); // Atualiza a referência da nova imagem
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}