package com.clara.claraprovaprogramacaoavancada.services;

import com.clara.claraprovaprogramacaoavancada.models.ProdutoModel;
import com.clara.claraprovaprogramacaoavancada.repositorys.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServices {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> findAll(){
       return produtoRepository.findAll();
    }

    public ProdutoModel criar (ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    public Optional findById(Long id){
        return produtoRepository.findById(id);
    }

    public void deletar (Long id){
        produtoRepository.deleteById(id);
    }

    public ProdutoModel atualizar (ProdutoModel produtoModel, Long id){
        ProdutoModel model = produtoRepository.findById(id).get();
        model.setNome(produtoModel.getNome());
        return produtoRepository.save(model);
    }


}
