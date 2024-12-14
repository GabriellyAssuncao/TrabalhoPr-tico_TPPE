package tst;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

// Em por enquanto tem apenas um teste de excecao
@RunWith(Categories.class)
@SuiteClasses({TestExcecao.class})
@IncludeCategory(TesteExcecao.class)
public class TestesExcecao {
    
}
