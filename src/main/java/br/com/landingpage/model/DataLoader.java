package br.com.landingpage.model;

import br.com.landingpage.repository.CategoriaRepository;
import br.com.landingpage.repository.DepoimentoRepository;
import br.com.landingpage.repository.ProdutoRepository;
import br.com.landingpage.repository.TipoPersonalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private DepoimentoRepository depoimentoRepository;

    @Autowired
    private TipoPersonalizacaoRepository tipoPersonalizacaoRepository;

    @Override
    public void run(String... args) throws Exception {
        // VERIFICAÇÃO PARA NÃO DUPLICAR DADOS
        if (categoriaRepository.count() > 0) {
            return;
        }

        // --- CATEGORIA NECESSAIRES ---
        Categoria necessaires = new Categoria();
        necessaires.setNomeSingular("Necessaire");
        necessaires.setNomePlural("Necessaires Personalizadas");
        necessaires.setSlug("necessaires");
        necessaires.setDescricao("Transforme sua rotina com necessaires 100% personalizadas. Cada peça é única, criada especialmente para refletir sua personalidade e organizar seus momentos mais importantes."); // Texto da Hero Section
        necessaires.setImagemDestaqueUrl("/images/Produtos/Necessaires/Necessaire Gatinho.jpeg");
        necessaires.setUrlImagemPersonalizacao("/images/Produtos/Necessaires/Necessaire Premium.jpeg");
        // Textos CTA para Necessaires
        necessaires.setCtaTitle("Sua Rotina Merece Essa Transformação...");
        necessaires.setCtaDescription("A organização muda tudo na sua vida. Que tal transformar sua rotina em algo mais prático e estiloso? Sua necessaire personalizada está a apenas um clique de distância. Vamos organizar juntas?");
        necessaires.setCtaAttention("⚡ ATENÇÃO: Devido à alta demanda, estamos com prazo de entrega de 3-5 dias. Garante já a sua antes que o prazo aumente!");
        necessaires.setCtaButtonText("✨ Criar Minha Necessaire"); // Texto do Botão CTA Final
        // Textos Hero Section
        necessaires.setHeroTitle("Necessaires que Organizam Sua Vida com Estilo");
        necessaires.setHeroButtonText("💝 Criar Minha Necessaire"); // NOVO TEXTO PARA O BOTÃO HERO
        categoriaRepository.save(necessaires);

        // Produtos para a categoria Necessaires
        Produto prodN1 = new Produto("Para Profissionais Especiais", "Designs que celebram sua profissão com carinho e orgulho", "/images/Produtos/Necessaires/Necessaire 6.jpg", necessaires);
        Produto prodN2 = new Produto("Amor pelos Pets", "Porque nossos bichinhos merecem estar sempre conosco", "/images/Produtos/Necessaires/Necessaire Cachorrinho.png", necessaires);
        Produto prodN3 = new Produto("Kits Coordenados", "Organização completa com estilo e elegância para seu dia a dia", "/images/Produtos/Necessaires/Necessaire Agatha.jpeg", necessaires);
        Produto prodN4 = new Produto("Fé que Acompanha", "Designs religiosos que fortalecem sua espiritualidade", "/images/Produtos/Necessaires/Necessaire Religiosa.jpeg", necessaires);
        Produto prodN5 = new Produto("Seus Personagens Favoritos", "Anime, desenhos e tudo que você ama em uma peça única", "/images/Produtos/Necessaires/Necessaire One Piece.jpeg", necessaires);
        Produto prodN6 = new Produto("A estampa que você escolher", "Quer uma estampa personalizada? Nós fazemos isso!", "/images/Produtos/Necessaires/Necessaire Estampa Tatiarte.jpeg", necessaires);
        produtoRepository.saveAll(Arrays.asList(prodN1, prodN2, prodN3, prodN4, prodN5, prodN6));

        // Depoimentos para a categoria Necessaires
        Depoimento depN1 = new Depoimento("Tati Oliveira", "\"Gente, que necessaire LINDA! 😍 A Rita ficou emocionada com a personagem. Ficou exatamente como a foto que a Tati me mostrou! Achei incrível! 🥰\"", "/images/Produtos/Necessaires/Necessaire Rita 395x385 .png", necessaires);
        Depoimento depN2 = new Depoimento("Ana Paula", "\"Me sinto abraçado por Jesus toda vez que uso 🙏✨ Tornou meus domingos ainda mais especiais!\". O acabamento é impecável e o material é super resistente! Amei demais! ❤️\"", "/images/Produtos/Necessaires/Necessaire Bolsa Jesus.jpeg", necessaires);
        Depoimento depN3 = new Depoimento("Agatha Mendes", "\"Meu kit de necessaires chegou! Que organização PERFEITA! Cada tamanho para uma função. Recomendo muito! 🥰\"", "/images/Produtos/Necessaires/Necessaire Maria Maris.jpeg", necessaires);
        Depoimento depN4 = new Depoimento("Luciana Consentino", "\"A necessaire que pedi ficou incrível! Dei te presente de dia das mães e ela amou! Disse que vai usar sempre, muito obrigada Tati!💕\"", "/images/Produtos/Necessaires/Necessaire Mae 395x385 .png", necessaires);
        Depoimento depN5 = new Depoimento("Bruna Chanes", "\"A necessaire do Frozen ficou perfeita! Todos os personagens perfeitos. Minha filha amou que veio junto o nome dela, deixou ainda mais especial!🥰\"", "/images/Produtos/Necessaires/Necessaire Frozen.jpeg", necessaires);
        Depoimento depN6 = new Depoimento("Carla Medeiros", "\"Necessaire premium para executivas! Organização total para viagens de trabalho. Qualidade excepcional, recomendo para todas as profissionais!\"", "/images/Produtos/Necessaires/Necessaire Premium Aberta 395x385 .png", necessaires);
        depoimentoRepository.saveAll(Arrays.asList(depN1, depN2, depN3, depN4, depN5, depN6));

        // TIPOS DE PERSONALIZAÇÃO PARA A CATEGORIA 'NECESSAIRES'
        TipoPersonalizacao tipoNecessaire1 = new TipoPersonalizacao();
        tipoNecessaire1.setTitulo("Pets e Animais");
        tipoNecessaire1.setNomeIcone("heart");
        tipoNecessaire1.setCategoria(necessaires);
        tipoNecessaire1.getItens().add(new ItemPersonalizacao("Fotos dos seus pets favoritos", tipoNecessaire1));
        tipoNecessaire1.getItens().add(new ItemPersonalizacao("Ilustrações personalizadas dos bichinhos", tipoNecessaire1));
        tipoNecessaire1.getItens().add(new ItemPersonalizacao("Nomes e datas especiais", tipoNecessaire1));
        tipoNecessaire1.getItens().add(new ItemPersonalizacao("Patinhas e símbolos fofos", tipoNecessaire1));
        tipoNecessaire1.getItens().add(new ItemPersonalizacao("Raças específicas e características únicas", tipoNecessaire1));

        TipoPersonalizacao tipoNecessaire2 = new TipoPersonalizacao();
        tipoNecessaire2.setTitulo("Profissões Especiais");
        tipoNecessaire2.setNomeIcone("briefcase");
        tipoNecessaire2.setCategoria(necessaires);
        tipoNecessaire2.getItens().add(new ItemPersonalizacao("Médicas, enfermeiras e profissionais da saúde", tipoNecessaire2));
        tipoNecessaire2.getItens().add(new ItemPersonalizacao("Professoras e educadoras", tipoNecessaire2));
        tipoNecessaire2.getItens().add(new ItemPersonalizacao("Advogadas e executivas", tipoNecessaire2));
        tipoNecessaire2.getItens().add(new ItemPersonalizacao("Símbolos e ferramentas da profissão", tipoNecessaire2));
        tipoNecessaire2.getItens().add(new ItemPersonalizacao("Frases motivacionais da área", tipoNecessaire2));

        TipoPersonalizacao tipoNecessaire3 = new TipoPersonalizacao();
        tipoNecessaire3.setTitulo("Fé e Espiritualidade");
        tipoNecessaire3.setNomeIcone("star");
        tipoNecessaire3.setCategoria(necessaires);
        tipoNecessaire3.getItens().add(new ItemPersonalizacao("Nossa Senhora e santos de devoção", tipoNecessaire3));
        tipoNecessaire3.getItens().add(new ItemPersonalizacao("Versículos bíblicos especiais", tipoNecessaire3));
        tipoNecessaire3.getItens().add(new ItemPersonalizacao("Símbolos religiosos personalizados", tipoNecessaire3));
        tipoNecessaire3.getItens().add(new ItemPersonalizacao("Orações e mensagens de fé", tipoNecessaire3));
        tipoNecessaire3.getItens().add(new ItemPersonalizacao("Anjos e elementos celestiais", tipoNecessaire3));

        TipoPersonalizacao tipoNecessaire4 = new TipoPersonalizacao();
        tipoNecessaire4.setTitulo("Anime e Personagens");
        tipoNecessaire4.setNomeIcone("gamepad-2");
        tipoNecessaire4.setCategoria(necessaires);
        tipoNecessaire4.getItens().add(new ItemPersonalizacao("Personagens de anime favoritos", tipoNecessaire4));
        tipoNecessaire4.getItens().add(new ItemPersonalizacao("Desenhos animados clássicos", tipoNecessaire4));
        tipoNecessaire4.getItens().add(new ItemPersonalizacao("Filmes e séries que você ama", tipoNecessaire4));
        tipoNecessaire4.getItens().add(new ItemPersonalizacao("Logos e símbolos icônicos", tipoNecessaire4));
        tipoNecessaire4.getItens().add(new ItemPersonalizacao("Frases marcantes dos personagens", tipoNecessaire4));

        TipoPersonalizacao tipoNecessaire5 = new TipoPersonalizacao();
        tipoNecessaire5.setTitulo("Nomes e Monogramas");
        tipoNecessaire5.setNomeIcone("palette");
        tipoNecessaire5.setCategoria(necessaires);
        tipoNecessaire5.getItens().add(new ItemPersonalizacao("Seu nome em tipografias exclusivas", tipoNecessaire5));
        tipoNecessaire5.getItens().add(new ItemPersonalizacao("Monogramas elegantes e sofisticados", tipoNecessaire5));
        tipoNecessaire5.getItens().add(new ItemPersonalizacao("Iniciais decorativas", tipoNecessaire5));
        tipoNecessaire5.getItens().add(new ItemPersonalizacao("Combinações de nomes especiais", tipoNecessaire5));
        tipoNecessaire5.getItens().add(new ItemPersonalizacao("Assinaturas personalizadas", tipoNecessaire5));

        TipoPersonalizacao tipoNecessaire6 = new TipoPersonalizacao();
        tipoNecessaire6.setTitulo("Estampas Exclusivas");
        tipoNecessaire6.setNomeIcone("sparkles");
        tipoNecessaire6.setCategoria(necessaires);
        tipoNecessaire6.getItens().add(new ItemPersonalizacao("Florais delicados e modernos", tipoNecessaire6));
        tipoNecessaire6.getItens().add(new ItemPersonalizacao("Padrões geométricos únicos", tipoNecessaire6));
        tipoNecessaire6.getItens().add(new ItemPersonalizacao("Aquarelas e arte abstrata", tipoNecessaire6));
        tipoNecessaire6.getItens().add(new ItemPersonalizacao("Combinações de cores favoritas", tipoNecessaire6));
        tipoNecessaire6.getItens().add(new ItemPersonalizacao("Texturas e efeitos especiais", tipoNecessaire6));
        tipoPersonalizacaoRepository.saveAll(Arrays.asList(tipoNecessaire1, tipoNecessaire2, tipoNecessaire3, tipoNecessaire4, tipoNecessaire5, tipoNecessaire6));

        // --- CATEGORIA CANECAS ---
        Categoria canecas = new Categoria();
        canecas.setNomeSingular("Caneca");
        canecas.setNomePlural("Canecas Personalizadas");
        canecas.setSlug("canecas");
        canecas.setDescricao("Transforme momentos especiais em lembranças eternas. Cada caneca é 100% personalizada e feita com amor para emocionar quem você ama."); // Texto da Hero Section
        canecas.setImagemDestaqueUrl("/images/Produtos/Caneca/Caneca 2.jpg");
        canecas.setUrlImagemPersonalizacao("/images/Produtos/Caneca/Copo Stanley.jpeg");
        // Textos CTA para Canecas
        canecas.setCtaTitle("Não Deixe Esse Momento Passar...");
        canecas.setCtaDescription("A vida é feita de momentos únicos. Que tal transformar o próximo em uma lembrança eterna? Sua caneca personalizada está a apenas um clique de distância. Vamos criar magia juntos?");
        canecas.setCtaAttention("⚡ ATENÇÃO: Devido à alta demanda, estamos com prazo de entrega de 3-5 dias. Garante já a sua antes que o prazo aumente!");
        canecas.setCtaButtonText("✨ SIM! Quero Minha Caneca Personalizada"); // Texto do Botão CTA Final
        // Textos Hero Section
        canecas.setHeroTitle("Canecas que Contam Histórias Únicas");
        canecas.setHeroButtonText("💝 Criar Minha Caneca"); // NOVO TEXTO PARA O BOTÃO HERO
        categoriaRepository.save(canecas);

        // Produtos para a categoria Canecas
        Produto c1 = new Produto("Para Mães Guerreiras", "Designs que celebram a maternidade com humor e amor", "/images/Produtos/Caneca/Caneca 1.jpg", canecas);
        Produto c2 = new Produto("Frases que Arrancam Risadas", "Porque toda mãe merece rir das próprias frases", "/images/caneca-frases-engracadas.jpg", canecas);
        Produto c3 = new Produto("Kits Presente Luxuosos", "Embalagens que fazem o presente ainda mais especial", "/images/Produtos/Caneca/Caneca 3.jpg", canecas);
        Produto c4 = new Produto("Mensagens que Inspiram", "Para começar cada dia com esperança e força", "/images/Produtos/Caneca/Caneca Frase Choro.png", canecas);
        Produto c5 = new Produto("Suas Sextas Mais Especiais", "Aquela caneca personalizada que vai fazer seu happy hour único! Seu nome, seu momento!", "/images/Produtos/Caneca/Caneca Heineken Danilo.png", canecas);
        Produto c6 = new Produto("Amor de Pet em Cada Gole", "Eternize momentos especiais com seu melhor amigo. Colher exclusiva para deixar seu café ainda mais doce!", "/images/Produtos/Caneca/caneca com colher pet.jpeg", canecas);
        produtoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));

        // Depoimentos para a categoria Canecas
        Depoimento dc1 = new Depoimento("Maria Santos", "\"Gente, olha que PERFEITA ficou a caneca da minha mãe! 😭❤️ Ela chorou quando viu. Muito obrigada, ficou exatamente como eu imaginei!\"", "/images/Produtos/Caneca/Depoimento 1.png", canecas);
        Depoimento dc2 = new Depoimento("Ana Clara", "\"Minha sogra AMOU as frases! Disse que finalmente alguém entende ela 😂 Qualidade incrível!\"", "https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b?w=300&h=200&fit=crop&crop=center", canecas);
        Depoimento dc3 = new Depoimento("Juliana Madalena", "\"Gente, que caneca MARAVILHOSA! 100% personalizada, exatamente como eu queria. Recomendo demais! 🥰\"", "https://images.unsplash.com/photo-1578662996442-48f60103fc96?w=300&h=200&fit=crop&crop=center", canecas);
        Depoimento dc4 = new Depoimento("Carla Mendes", "\"O kit ficou LINDO! A embalagem, o cuidado com cada detalhe... Minha mãe se emocionou muito ❤️\"", "/images/Produtos/Caneca/caneca mae avo etc.jpeg", canecas);
        Depoimento dc5 = new Depoimento("Roberta Lima", "\"Fiz um vídeo mostrando como ficou perfeita! Cada detalhe pensado com carinho. Nota 1000!\"", "https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=300&h=200&fit=crop&crop=center", canecas);
        Depoimento dc6 = new Depoimento("Empresa TechCorp", "\"Fizemos 100 canecas personalizadas para o Dia das Mães. Todas as funcionárias ficaram emocionadas! Qualidade excepcional.\"", "https://images.unsplash.com/photo-1495474472287-4d71bcdd2085?w=300&h=200&fit=crop&crop=center", canecas);
        depoimentoRepository.saveAll(Arrays.asList(dc1, dc2, dc3, dc4, dc5, dc6));

        // TIPOS DE PERSONALIZAÇÃO PARA A CATEGORIA 'CANECAS'
        TipoPersonalizacao tipoCaneca1 = new TipoPersonalizacao();
        tipoCaneca1.setTitulo("Para Mães e Avós");
        tipoCaneca1.setNomeIcone("heart");
        tipoCaneca1.setCategoria(canecas);
        tipoCaneca1.getItens().add(new ItemPersonalizacao("Datas especiais (nascimento dos filhos/netos)", tipoCaneca1));
        tipoCaneca1.getItens().add(new ItemPersonalizacao("Frases marcantes que toda mãe fala", tipoCaneca1));
        tipoCaneca1.getItens().add(new ItemPersonalizacao("Fotos da família", tipoCaneca1));
        tipoCaneca1.getItens().add(new ItemPersonalizacao("Mensagens de amor dos filhos", tipoCaneca1));
        tipoCaneca1.getItens().add(new ItemPersonalizacao("Desenhos das crianças", tipoCaneca1));

        TipoPersonalizacao tipoCaneca2 = new TipoPersonalizacao();
        tipoCaneca2.setTitulo("Casais e Relacionamentos");
        tipoCaneca2.setNomeIcone("users");
        tipoCaneca2.setCategoria(canecas);
        tipoCaneca2.getItens().add(new ItemPersonalizacao("Data do primeiro encontro", tipoCaneca2));
        tipoCaneca2.getItens().add(new ItemPersonalizacao("Fotos do casal", tipoCaneca2));
        tipoCaneca2.getItens().add(new ItemPersonalizacao("Frases especiais entre vocês", tipoCaneca2));
        tipoCaneca2.getItens().add(new ItemPersonalizacao("Coordenadas de lugares importantes", tipoCaneca2));
        tipoCaneca2.getItens().add(new ItemPersonalizacao("Linha do tempo do relacionamento", tipoCaneca2));

        TipoPersonalizacao tipoCaneca3 = new TipoPersonalizacao();
        tipoCaneca3.setTitulo("Motivacional");
        tipoCaneca3.setNomeIcone("sparkles");
        tipoCaneca3.setCategoria(canecas);
        tipoCaneca3.getItens().add(new ItemPersonalizacao("Frases inspiradoras personalizadas", tipoCaneca3));
        tipoCaneca3.getItens().add(new ItemPersonalizacao("Metas e objetivos", tipoCaneca3));
        tipoCaneca3.getItens().add(new ItemPersonalizacao("Versículos bíblicos", tipoCaneca3));
        tipoCaneca3.getItens().add(new ItemPersonalizacao("Mantras pessoais", tipoCaneca3));
        tipoCaneca3.getItens().add(new ItemPersonalizacao("Conquistas e vitórias", tipoCaneca3));

        TipoPersonalizacao tipoCaneca4 = new TipoPersonalizacao();
        tipoCaneca4.setTitulo("Datas Especiais");
        tipoCaneca4.setNomeIcone("gift");
        tipoCaneca4.setCategoria(canecas);
        tipoCaneca4.getItens().add(new ItemPersonalizacao("Aniversários únicos", tipoCaneca4));
        tipoCaneca4.getItens().add(new ItemPersonalizacao("Formaturas e conquistas", tipoCaneca4));
        tipoCaneca4.getItens().add(new ItemPersonalizacao("Aposentadoria", tipoCaneca4));
        tipoCaneca4.getItens().add(new ItemPersonalizacao("Nascimento de bebês", tipoCaneca4));
        tipoCaneca4.getItens().add(new ItemPersonalizacao("Bodas e aniversários de casamento", tipoCaneca4));

        TipoPersonalizacao tipoCaneca5 = new TipoPersonalizacao();
        tipoCaneca5.setTitulo("Profissional");
        tipoCaneca5.setNomeIcone("coffee");
        tipoCaneca5.setCategoria(canecas);
        tipoCaneca5.getItens().add(new ItemPersonalizacao("Logo da empresa", tipoCaneca5));
        tipoCaneca5.getItens().add(new ItemPersonalizacao("Nome e cargo personalizado", tipoCaneca5));
        tipoCaneca5.getItens().add(new ItemPersonalizacao("Brindes corporativos", tipoCaneca5));
        tipoCaneca5.getItens().add(new ItemPersonalizacao("Eventos e convenções", tipoCaneca5));
        tipoCaneca5.getItens().add(new ItemPersonalizacao("Presentes para equipe", tipoCaneca5));

        TipoPersonalizacao tipoCaneca6 = new TipoPersonalizacao();
        tipoCaneca6.setTitulo("Arte Personalizada");
        tipoCaneca6.setNomeIcone("palette");
        tipoCaneca6.setCategoria(canecas);
        tipoCaneca6.getItens().add(new ItemPersonalizacao("Ilustrações exclusivas", tipoCaneca6));
        tipoCaneca6.getItens().add(new ItemPersonalizacao("Retratos artísticos", tipoCaneca6));
        tipoCaneca6.getItens().add(new ItemPersonalizacao("Pets e animais de estimação", tipoCaneca6));
        tipoCaneca6.getItens().add(new ItemPersonalizacao("Paisagens especiais", tipoCaneca6));
        tipoCaneca6.getItens().add(new ItemPersonalizacao("Arte abstrata personalizada", tipoCaneca6));
        tipoPersonalizacaoRepository.saveAll(Arrays.asList(tipoCaneca1, tipoCaneca2, tipoCaneca3, tipoCaneca4, tipoCaneca5, tipoCaneca6));

        // --- CATEGORIA BOLSAS ---
        Categoria bolsas = new Categoria();
        bolsas.setNomeSingular("Bolsa");
        bolsas.setNomePlural("Bolsas Personalizadas");
        bolsas.setSlug("bolsas");
        bolsas.setDescricao("Carregue sua história todos os dias. Cada bolsa tote é uma obra de arte única.");
        bolsas.setImagemDestaqueUrl("/images/Produtos/Bolsa/Bolsa Tote 4 Estilos.jpeg");
        bolsas.setUrlImagemPersonalizacao("/images/Produtos/Bolsa/Tati Preparação Bolsa.png");
        bolsas.setCtaTitle("Carregue Sua História Com Estilo!");
        bolsas.setCtaDescription("Sua bolsa tote, sua declaração. Crie uma peça que seja tão única quanto você, combinando praticidade e design exclusivo para o seu dia a dia.");
        bolsas.setCtaAttention("⚡ ATENÇÃO: Peças personalizadas levam 3-5 dias para serem criadas. Garanta sua bolsa exclusiva com antecedência!");
        bolsas.setCtaButtonText("✨ SIM! Quero Minha Bolsa Personalizada"); // NOVO TEXTO PARA O BOTÃO
        // Textos Hero Section para Bolsas
        bolsas.setHeroTitle("Bolsas que Contam Sua História com Arte!"); // Título da Hero Section
        bolsas.setHeroButtonText("💝 Criar Minha Bolsa"); // Texto do Botão Hero Section
        categoriaRepository.save(bolsas);

        // Produtos para a categoria Bolsas
        Produto b1 = new Produto("Elegância no Dia a Dia", "Bolsas que combinam sofisticação e praticidade", "/images/Produtos/Bolsa/790x770 Bolsas Tote Fundo Branco.png", bolsas);
        Produto b2 = new Produto("Personalidade Vibrante", "Cores que expressam sua energia e desenhos que contam sua história", "/images/Produtos/Bolsa/790x770 Bolsa Vermlha Fundo Branco.png", bolsas);
        produtoRepository.saveAll(Arrays.asList(b1, b2));

        // Adicione os depoimentos para bolsas
        Depoimento db1 = new Depoimento("Carla Fernandes", "\"Gente, que bolsa PERFEITA! 😍 As 'Mulheres Poderosas' ficaram lindas demais!\"", "/images/Produtos/Bolsa/790x770 Bolsas Mulheres Poderosas Experience.png", bolsas);
        depoimentoRepository.save(db1);

        // --- CATEGORIA ESTOJOS ---
        Categoria estojos = new Categoria();
        estojos.setNomeSingular("Estojo");
        estojos.setNomePlural("Estojos Personalizados");
        estojos.setSlug("estojos");
        estojos.setDescricao("Estojos personalizados que encantam crianças e organizam o material escolar com estilo e personalidade.");
        estojos.setImagemDestaqueUrl("/images/Produtos/Estojo/Estojo Tatiart.jpeg");
        estojos.setUrlImagemPersonalizacao("/images/Produtos/Estojo/Estojo Turma Animais.jpeg");
        estojos.setCtaTitle("Transforme a Volta às Aulas em um Momento Especial");
        estojos.setCtaDescription("Um estojo personalizado faz toda a diferença. Imagine o sorriso do seu filho ao receber um estojo único, com seu personagem favorito e seu nome. Faça da organização escolar algo divertido e especial!");
        estojos.setCtaAttention("⚡ ATENÇÃO: Garanta já o estojo personalizado do seu filho antes do início das aulas! Faça o pedido com antecedência para receber a tempo.");
        estojos.setCtaButtonText("✨ SIM! Quero Meu Estojo Personalizado"); // Texto do Botão CTA Final
        // Textos Hero Section para Estojos
        estojos.setHeroTitle("Estojos que Encantam e Organizam com Estilo"); // Título da Hero Section
        estojos.setHeroButtonText("💝 Criar Meu Estojo"); // Texto do Botão Hero Section
        categoriaRepository.save(estojos);

        // --- Produtos específicos para Estojos ---
        Produto estojo1 = new Produto(
                "Conjuntos Coordenados",
                "Estojos e mochilas que combinam para um visual completo e organizado.",
                "/images/Produtos/Estojo/960x640 Estojo e Mochila.png",
                estojos
        );

        Produto estojo2 = new Produto(
                "Heróis Favoritos",
                "Personagens que inspiram e acompanham seu filho todos os dias.",
                "/images/Produtos/Estojo/960x640 Estojo Homem Aranha.png",
                estojos
        );

        Produto estojo3 = new Produto(
                "Designs Divertidos",
                "Formatos criativos que trazem alegria para a rotina escolar.",
                "/images/Produtos/Estojo/960x640 Abelhinas.png",
                estojos
        );

        Produto estojo4 = new Produto(
                "Proteção para Óculos",
                "Estojos especiais que protegem os óculos com estilo e segurança.",
                "/images/Produtos/Estojo/960x640 Estojo Óculos.png",
                estojos
        );

        Produto estojo5 = new Produto(
                "Nomes Personalizados",
                "Estojos únicos com o nome do seu filho, evitando trocas e perdas.",
                "/images/Produtos/Estojo/960x640 Estojo Ady.png",
                estojos
        );

        Produto estojo6 = new Produto(
                "Estampas Exclusivas",
                "Padrões únicos que combinam com a personalidade de cada criança.",
                "/images/Produtos/Estojo/960x640 Estojo Gatinhos.png",
                estojos
        );

        produtoRepository.saveAll(Arrays.asList(estojo1, estojo2, estojo3, estojo4, estojo5, estojo6));

        // --- TIPOS DE PERSONALIZAÇÃO PARA A CATEGORIA 'ESTOJOS' ---
        TipoPersonalizacao tipoEstojo1 = new TipoPersonalizacao();
        tipoEstojo1.setTitulo("Animais e Bichinhos");
        tipoEstojo1.setNomeIcone("heart");
        tipoEstojo1.setCategoria(estojos);
        tipoEstojo1.getItens().add(new ItemPersonalizacao("Estojos em formato de animais fofos", tipoEstojo1));
        tipoEstojo1.getItens().add(new ItemPersonalizacao("Estampas com pets e bichinhos", tipoEstojo1));
        tipoEstojo1.getItens().add(new ItemPersonalizacao("Designs com animais da floresta", tipoEstojo1));
        tipoEstojo1.getItens().add(new ItemPersonalizacao("Padrões com dinossauros", tipoEstojo1));
        tipoEstojo1.getItens().add(new ItemPersonalizacao("Temas marinhos com peixinhos", tipoEstojo1));

        TipoPersonalizacao tipoEstojo2 = new TipoPersonalizacao();
        tipoEstojo2.setTitulo("Personagens Favoritos");
        tipoEstojo2.setNomeIcone("tv");
        tipoEstojo2.setCategoria(estojos);
        tipoEstojo2.getItens().add(new ItemPersonalizacao("Super-heróis (Homem-Aranha, Batman)", tipoEstojo2));
        tipoEstojo2.getItens().add(new ItemPersonalizacao("Princesas e personagens Disney", tipoEstojo2));
        tipoEstojo2.getItens().add(new ItemPersonalizacao("Personagens de desenhos animados", tipoEstojo2));
        tipoEstojo2.getItens().add(new ItemPersonalizacao("Jogos populares como Minecraft e Roblox", tipoEstojo2));
        tipoEstojo2.getItens().add(new ItemPersonalizacao("Animes e mangás para os mais velhos", tipoEstojo2));

        TipoPersonalizacao tipoEstojo3 = new TipoPersonalizacao();
        tipoEstojo3.setTitulo("Temas Mágicos");
        tipoEstojo3.setNomeIcone("star");
        tipoEstojo3.setCategoria(estojos);
        tipoEstojo3.getItens().add(new ItemPersonalizacao("Unicórnios e arco-íris", tipoEstojo3));
        tipoEstojo3.getItens().add(new ItemPersonalizacao("Fadas e elementos mágicos", tipoEstojo3));
        tipoEstojo3.getItens().add(new ItemPersonalizacao("Espaço e planetas", tipoEstojo3));
        tipoEstojo3.getItens().add(new ItemPersonalizacao("Sereias e criaturas míticas", tipoEstojo3));
        tipoEstojo3.getItens().add(new ItemPersonalizacao("Dragões e castelos", tipoEstojo3));

        TipoPersonalizacao tipoEstojo4 = new TipoPersonalizacao();
        tipoEstojo4.setTitulo("Hobbies e Esportes");
        tipoEstojo4.setNomeIcone("gamepad-2");
        tipoEstojo4.setCategoria(estojos);
        tipoEstojo4.getItens().add(new ItemPersonalizacao("Futebol e times favoritos", tipoEstojo4));
        tipoEstojo4.getItens().add(new ItemPersonalizacao("Ballet e dança", tipoEstojo4));
        tipoEstojo4.getItens().add(new ItemPersonalizacao("Instrumentos musicais", tipoEstojo4));
        tipoEstojo4.getItens().add(new ItemPersonalizacao("Skate e esportes radicais", tipoEstojo4));
        tipoEstojo4.getItens().add(new ItemPersonalizacao("Videogames e controles", tipoEstojo4));

        TipoPersonalizacao tipoEstojo5 = new TipoPersonalizacao();
        tipoEstojo5.setTitulo("Nomes e Iniciais");
        tipoEstojo5.setNomeIcone("text");
        tipoEstojo5.setCategoria(estojos);
        tipoEstojo5.getItens().add(new ItemPersonalizacao("Nome completo em designs criativos", tipoEstojo5));
        tipoEstojo5.getItens().add(new ItemPersonalizacao("Iniciais decoradas e estilizadas", tipoEstojo5));
        tipoEstojo5.getItens().add(new ItemPersonalizacao("Apelidos carinhosos", tipoEstojo5));
        tipoEstojo5.getItens().add(new ItemPersonalizacao("Combinações com símbolos favoritos", tipoEstojo5));
        tipoEstojo5.getItens().add(new ItemPersonalizacao("Letras em diferentes estilos e fontes", tipoEstojo5));

        TipoPersonalizacao tipoEstojo6 = new TipoPersonalizacao();
        tipoEstojo6.setTitulo("Estampas Exclusivas");
        tipoEstojo6.setNomeIcone("sparkles");
        tipoEstojo6.setCategoria(estojos);
        tipoEstojo6.getItens().add(new ItemPersonalizacao("Padrões geométricos coloridos", tipoEstojo6));
        tipoEstojo6.getItens().add(new ItemPersonalizacao("Estampas tie-dye", tipoEstojo6));
        tipoEstojo6.getItens().add(new ItemPersonalizacao("Galáxias e elementos cósmicos", tipoEstojo6));
        tipoEstojo6.getItens().add(new ItemPersonalizacao("Flores e elementos da natureza", tipoEstojo6));
        tipoEstojo6.getItens().add(new ItemPersonalizacao("Estampas abstratas e artísticas", tipoEstojo6));
        tipoPersonalizacaoRepository.saveAll(Arrays.asList(tipoEstojo1, tipoEstojo2, tipoEstojo3, tipoEstojo4, tipoEstojo5, tipoEstojo6));

        // --- DEPOIMENTOS DA PÁGINA: Estojos.html ---
        Depoimento depEstojo1 = new Depoimento(
                "Tati Oliveira",
                "\"Meu filho ficou super empolgado com o estojo do Among Us! 🚀 Os personagens ficaram idênticos ao jogo! O zíper verde combinou perfeitamente com o tema. Ele não para de mostrar para os amigos! 😍\"",
                "/images/Produtos/Estojo/790x770 Estojo Among.png",
                estojos
        );

        Depoimento depEstojo2 = new Depoimento(
                "Ana Paula",
                "\"Os estojos de dinossauros do Bento ficaram perfeitos! 🦖 As cores vibrantes e os detalhes são incríveis! Meu filho adora os zíperes com os pingentes de dinossauros. Material super resistente para o dia a dia escolar! 🌟\"",
                "/images/Produtos/Estojo/790x770 Estojo Bento.png",
                estojos
        );

        Depoimento depEstojo3 = new Depoimento(
                "Agatha Mendes",
                "\"O estojo do Mickey ficou incrível! 🐭 Meu filho é apaixonado por quadrinhos e esse design em preto e branco com os detalhes coloridos ficou super estiloso. Ele é o mais animado da turma na hora de guardar os lápis! 📚\"",
                "/images/Produtos/Estojo/790x770 Estojo Mickey.png",
                estojos
        );

        Depoimento depEstojo4 = new Depoimento(
                "Luciana Consentino",
                "\"O kit de unicórnios é simplesmente mágico! 🦄✨ Minha filha ficou encantada com as carinhas fofas e as cores. O conjunto com três estojos diferentes ajuda muito na organização do material escolar. Qualidade incrível! 💕\"",
                "/images/Produtos/Estojo/790x770 Estojo Kit Unicornio.png",
                estojos
        );

        Depoimento depEstojo5 = new Depoimento(
                "Bruna Chanes",
                "\"A necessaire do Frozen ficou perfeita! Todos os personagens perfeitos. Minha filha amou que veio junto o nome dela, deixou ainda mais especial!🥰\"",
                "/images/Produtos/Estojo/790x770 Estojo Celsa Schimidtz.png",
                estojos
        );

        Depoimento depEstojo6 = new Depoimento(
                "Carla Medeiros",
                "\"O estojo do Bob Esponja fez o maior sucesso! 🍍 Meu filho adora todos os personagens e as cores vibrantes. O tamanho é perfeito para todos os lápis e canetas da escola. Ele não troca por nada! 🌊🧽\"",
                "/images/Produtos/Estojo/790x770 Estojo Bob Esponja.png",
                estojos
        );

        depoimentoRepository.saveAll(Arrays.asList(depEstojo1, depEstojo2, depEstojo3, depEstojo4, depEstojo5, depEstojo6));

        // --- CATEGORIA MOCHILAS ---
        Categoria mochilas = new Categoria();
        mochilas.setNomeSingular("Mochila");
        mochilas.setNomePlural("Mochilas Personalizadas");
        mochilas.setSlug("mochilas");
        mochilas.setDescricao("Transforme sua rotina com mochilas 100% personalizadas. Cada peça é única, criada especialmente para refletir sua personalidade e organizar seus momentos mais importantes.");
        mochilas.setImagemDestaqueUrl("/images/Produtos/Mochila/Mochila Hero.jpg");
        mochilas.setUrlImagemPersonalizacao("/images/Produtos/Mochila/Mochila 4.jpg");
        // Textos CTA para Mochilas
        mochilas.setCtaTitle("Prepare-se Para Aventura com Sua Mochila Perfeita!");
        mochilas.setCtaDescription("Sua mochila é mais que um acessório, é sua companheira de jornada. Crie uma peça única que reflita sua personalidade e organize suas aventuras com estilo. Do dia a dia à grandes viagens.");
        mochilas.setCtaAttention("⚡ ATENÇÃO: Devido à alta demanda, garanta sua mochila personalizada agora para receber a tempo! Qualidade e design exclusivos.");
        mochilas.setCtaButtonText("✨ SIM! Quero Minha Mochila Personalizada"); // NOVO TEXTO PARA O BOTÃO
        // Textos Hero Section para Mochilas
        mochilas.setHeroTitle("Mochilas que te Acompanham em Todas as Aventuras"); // Título da Hero Section
        mochilas.setHeroButtonText("💝 Criar Minha Mochila"); // Texto do Botão Hero Section
        categoriaRepository.save(mochilas);

        // Produtos para a categoria Mochilas
        Produto m1 = new Produto("Para Profissionais Especiais", "Designs que celebram sua profissão com carinho e orgulho", "/images/Produtos/Estojo/960x640 Estojo e Mochila.png", mochilas);
        Produto m2 = new Produto("Amor pelos Pets", "Porque nossos bichinhos merecem estar sempre conosco", "/images/Produtos/Estojo/960x640 Estojo Homem Aranha.png", mochilas);
        Produto m3 = new Produto("Kits Coordenados", "Organização completa com estilo e elegância para seu dia a dia", "/images/Produtos/Estojo/960x640 Abelhinas.png", mochilas);
        Produto m4 = new Produto("Fé que Acompanha", "Designs religiosos que fortalecem sua espiritualidade", "/images/Produtos/Estojo/960x640 Estojo Óculos.png", mochilas);
        Produto m5 = new Produto("Seus Personagens Favoritos", "Anime, desenhos e tudo que você ama em uma peça única", "/images/Produtos/Estojo/960x640 Estojo Ady.png", mochilas);
        Produto m6 = new Produto("A estampa que você escolher", "Quer uma estampa personalizada? Nós fazemos isso!", "/images/Produtos/Estojo/960x640 Estojo Gatinhos.png", mochilas);
        produtoRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5, m6));

        // Adicione os depoimentos para Mochilas
        Depoimento dm1 = new Depoimento("Tati Oliveira", "\"Gente, que mochila LINDA! 😍 A Rita ficou emocionada com a personagem. Ficou exatamente como a foto que a Tati me mostrou! Achei incrível! 🥰\"", "/images/Produtos/Estojo/790x770 Estojo Among.png", mochilas);
        Depoimento dm2 = new Depoimento("Ana Paula", "\"Me sinto abraçado por Jesus toda vez que uso 🙏✨ Tornou meus domingos ainda mais especiais!\". O acabamento é impecável e o material é super resistente! Amei demais! ❤️\"", "/images/Produtos/Estojo/790x770 Estojo Bento.png", mochilas);
        Depoimento dm3 = new Depoimento("Agatha Mendes", "\"Minha mochila chegou! Que organização PERFEITA! Cada tamanho para uma função. Recomendo muito! 🥰\"", "/images/Produtos/Estojo/790x770 Estojo Mickey.png", mochilas);
        Depoimento dm4 = new Depoimento("Luciana Consentino", "\"A mochila que pedi ficou incrível! Dei de presente de dia das mães e ela amou! Disse que vai usar sempre, muito obrigada Tati!💕\"", "/images/Produtos/Estojo/790x770 Estojo Kit Unicornio.png", mochilas);
        Depoimento dm5 = new Depoimento("Bruna Chanes", "\"A mochila do Frozen ficou perfeita! Todos os personagens perfeitos. Minha filha amou que veio junto o nome dela, deixou ainda mais especial!🥰\"", "/images/Produtos/Estojo/790x770 Estojo Celsa Schimidtz.png", mochilas);
        Depoimento dm6 = new Depoimento("Carla Medeiros", "\"Mochila premium para executivas! Organização total para viagens de trabalho. Qualidade excepcional, recomendo para todas as profissionais!\"", "/images/Produtos/Estojo/790x770 Estojo Bob Esponja.png", mochilas);
        depoimentoRepository.saveAll(Arrays.asList(dm1, dm2, dm3, dm4, dm5, dm6));

        // TIPOS DE PERSONALIZAÇÃO PARA A CATEGORIA 'MOCHILAS'
        TipoPersonalizacao tipoMochila1 = new TipoPersonalizacao();
        tipoMochila1.setTitulo("Pets e Animais");
        tipoMochila1.setNomeIcone("heart");
        tipoMochila1.setCategoria(mochilas);
        tipoMochila1.getItens().add(new ItemPersonalizacao("Fotos dos seus pets favoritos", tipoMochila1));
        tipoMochila1.getItens().add(new ItemPersonalizacao("Ilustrações personalizadas dos bichinhos", tipoMochila1));
        tipoMochila1.getItens().add(new ItemPersonalizacao("Nomes e datas especiais", tipoMochila1));
        tipoMochila1.getItens().add(new ItemPersonalizacao("Patinhas e símbolos fofos", tipoMochila1));
        tipoMochila1.getItens().add(new ItemPersonalizacao("Raças específicas e características únicas", tipoMochila1));

        TipoPersonalizacao tipoMochila2 = new TipoPersonalizacao();
        tipoMochila2.setTitulo("Profissões Especiais");
        tipoMochila2.setNomeIcone("briefcase");
        tipoMochila2.setCategoria(mochilas);
        tipoMochila2.getItens().add(new ItemPersonalizacao("Médicas, enfermeiras e profissionais da saúde", tipoMochila2));
        tipoMochila2.getItens().add(new ItemPersonalizacao("Professoras e educadoras", tipoMochila2));
        tipoMochila2.getItens().add(new ItemPersonalizacao("Advogadas e executivas", tipoMochila2));
        tipoMochila2.getItens().add(new ItemPersonalizacao("Símbolos e ferramentas da profissão", tipoMochila2));
        tipoMochila2.getItens().add(new ItemPersonalizacao("Frases motivacionais da área", tipoMochila2));

        TipoPersonalizacao tipoMochila3 = new TipoPersonalizacao();
        tipoMochila3.setTitulo("Fé e Espiritualidade");
        tipoMochila3.setNomeIcone("star");
        tipoMochila3.setCategoria(mochilas);
        tipoMochila3.getItens().add(new ItemPersonalizacao("Nossa Senhora e santos de devoção", tipoMochila3));
        tipoMochila3.getItens().add(new ItemPersonalizacao("Versículos bíblicos especiais", tipoMochila3));
        tipoMochila3.getItens().add(new ItemPersonalizacao("Símbolos religiosos personalizados", tipoMochila3));
        tipoMochila3.getItens().add(new ItemPersonalizacao("Orações e mensagens de fé", tipoMochila3));
        tipoMochila3.getItens().add(new ItemPersonalizacao("Anjos e elementos celestiais", tipoMochila3));

        TipoPersonalizacao tipoMochila4 = new TipoPersonalizacao();
        tipoMochila4.setTitulo("Anime e Personagens");
        tipoMochila4.setNomeIcone("gamepad-2");
        tipoMochila4.setCategoria(mochilas);
        tipoMochila4.getItens().add(new ItemPersonalizacao("Personagens de anime favoritos", tipoMochila4));
        tipoMochila4.getItens().add(new ItemPersonalizacao("Desenhos animados clássicos", tipoMochila4));
        tipoMochila4.getItens().add(new ItemPersonalizacao("Filmes e séries que você ama", tipoMochila4));
        tipoMochila4.getItens().add(new ItemPersonalizacao("Logos e símbolos icônicos", tipoMochila4));
        tipoMochila4.getItens().add(new ItemPersonalizacao("Frases marcantes dos personagens", tipoMochila4));

        TipoPersonalizacao tipoMochila5 = new TipoPersonalizacao();
        tipoMochila5.setTitulo("Nomes e Monogramas");
        tipoMochila5.setNomeIcone("palette");
        tipoMochila5.setCategoria(mochilas);
        tipoMochila5.getItens().add(new ItemPersonalizacao("Seu nome em tipografias exclusivas", tipoMochila5));
        tipoMochila5.getItens().add(new ItemPersonalizacao("Monogramas elegantes e sofisticados", tipoMochila5));
        tipoMochila5.getItens().add(new ItemPersonalizacao("Iniciais decorativas", tipoMochila5));
        tipoMochila5.getItens().add(new ItemPersonalizacao("Combinações de nomes especiais", tipoMochila5));
        tipoMochila5.getItens().add(new ItemPersonalizacao("Assinaturas personalizadas", tipoMochila5));

        TipoPersonalizacao tipoMochila6 = new TipoPersonalizacao();
        tipoMochila6.setTitulo("Estampas Exclusivas");
        tipoMochila6.setNomeIcone("sparkles");
        tipoMochila6.setCategoria(mochilas);
        tipoMochila6.getItens().add(new ItemPersonalizacao("Florais delicados e modernos", tipoMochila6));
        tipoMochila6.getItens().add(new ItemPersonalizacao("Padrões geométricos únicos", tipoMochila6));
        tipoMochila6.getItens().add(new ItemPersonalizacao("Aquarelas e arte abstrata", tipoMochila6));
        tipoMochila6.getItens().add(new ItemPersonalizacao("Combinações de cores favoritas", tipoMochila6));
        tipoMochila6.getItens().add(new ItemPersonalizacao("Texturas e efeitos especiais", tipoMochila6));
        tipoPersonalizacaoRepository.saveAll(Arrays.asList(tipoMochila1, tipoMochila2, tipoMochila3, tipoMochila4, tipoMochila5, tipoMochila6));
    }
}