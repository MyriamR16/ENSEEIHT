clear all; 
close all; 

Fe = 24000;
Te = 1/Fe;
Rb = 3000;
Tb = 1/Rb;
Ns = floor(Tb/Te);
nbits = 1000;
bits = randi([0 1], 1, nbits);
hmef = ones(1,Ns);

avecbruit = true;

%%%%%%%%%%%%%% Chaine 1 %%%%%%%%%%%%%%%%%
ak1 = 2 * bits - 1;
h1 = ones(1, Ns);
x1 = kron(ak1, [1 zeros(1, Ns-1)]);
x = filter(hmef,1,x1);
g1 = conv(h1,hmef);

M1 = 2;
n0_1 =8;
bruitmax1 = 8;

EbN0db = [0:bruitmax1];
EbN0=10.^(EbN0db./10);

TEB1 = zeros(1,bruitmax1+1);
TEB_theorique = qfunc(sqrt(2*(log2(M1)*EbN0)));


for k=1:length(EbN0db)
    rapp = EbN0(k);
    sigma1 = mean(abs(x).^2)*Ns/(2*log2(M1)*rapp);
    bruit1=sqrt(sigma1)*randn(1,length(x));
    
    if avecbruit == true
    signal_propage = x + bruit1; %avec bruit
    else
    signal_propage = x; %sans bruit
    end
    z1 = filter(h1, 1, signal_propage);
    
    
    z_echantillone1 = z1(n0_1:Ns:end);
    
    decisions1 = (sign(z_echantillone1)+1)/2;
    taux_erreur1 = sum(decisions1 ~= bits) / length(bits);
    TEB1(k) = taux_erreur1;
    
    if k == 1 
        plot1 = reshape(z1,Ns,length(z1)/Ns);
    end
end

if avecbruit == true
    figure
    nexttile
    plot(plot1);
    title("Diagramme de l'oeil de la chaine 1 avec Eb/N0 = 1 db " )

    nexttile
    plot(reshape(z1,Ns,length(z1)/Ns));
    title("Diagramme de l'oeil de la chaine 1 avec Eb/N0 =  " + bruitmax1 + "db")

    figure 
    semilogy(EbN0db,TEB1,'r');
    hold on 
    semilogy(EbN0db,TEB_theorique,'b');
    hold off
    legend('empirique', "theorique")
    
else
    figure
    nexttile
    plot(reshape(z1,Ns,length(z1)/Ns));
    title("Diagramme de l'oeil de la chaine 1 sans bruit " );

    nexttile
    stem(g1);
    title("Tracé de la fct g pour la chaine 1")
end


%%%%%%%%%%%%%% Chaine 2 %%%%%%%%%%%%%%%%%
ak2 = 2 * bits - 1;
h2 = ones(1, Ns/2);
x2 = kron(ak2, [1 zeros(1, Ns-1)]);
x = filter(hmef,1,x2);
g2 = conv(hmef,h2);

M2 = 2;
n0_2 = 4;
bruitmax2 = 8;

EbN0db2 = [0:bruitmax2+1];
EbN02=10.^(EbN0db2./10);

TEB2 = zeros(1,bruitmax2);
TEB_theorique2 = qfunc(sqrt((log2(M2)*EbN02)));

for k=1:length(EbN0db2)
    rapp = EbN02(k);
    sigma2 = mean(abs(x).^2)*Ns/(2*log2(M2)*rapp);
    bruit2=sqrt(sigma2)*randn(1,length(x));
    
    if avecbruit == true
    signal_propage = x + bruit2; %avec bruit
    else
    signal_propage = x; %sans bruit
    end
    
    z2 = filter(h2, 1, signal_propage);
    z_echantillone2 = z2(n0_2:Ns:end);
    
    decisions2 = (sign(z_echantillone2)+1)/2;
    taux_erreur2 = sum(decisions2 ~= bits) / length(bits);
    TEB2(k) = taux_erreur2;
    
    if k == 1 
        plot2 = reshape(z2,Ns,length(z2)/Ns);
    end
end

if avecbruit == true
    figure
    nexttile
    plot(plot2);
    title("Diagramme de l'oeil de la chaine 2 avec Eb/N0 = 1 " )

    nexttile
    plot(reshape(z2,Ns,length(z2)/Ns));
    title("Diagramme de l'oeil de la chaine 2 avec Eb/N0 =  " + bruitmax2)

    figure 
    semilogy(EbN0db2,TEB2,'r');
    hold on 
    semilogy(EbN0db2,TEB_theorique2,'b');
    hold off
    legend('empirique', "theorique")
    
else
    figure
    nexttile
    plot(reshape(z2,Ns,length(z2)/Ns));
    title("Diagramme de l'oeil de la chaine 2 sans bruit "  );

    nexttile
    stem(g2);
    title("Tracé de la fct g pour la chaine 2")
end


%%%%%%%%%%%%%%%%% Chaine 3 %%%%%%%%%%%%%%%%%
%mapping = [-3 -1 1 3];
%ak3 = reshape(bits,2,[]);
%ak3 = mapping(bi2de(ak3','left-msb') + 1);
%x3 = kron(ak3, [1 zeros(1, Ns-1)]);
%x = filter(hmef,1,x3);
Ns = floor(2*Tb/Te);
hmef = ones(1,Ns);
Nb = size(bits,2);
M3 = 4; 
entiers= bi2de(reshape(bits,2,[])');
ak3 = real(pammod(entiers,M3));
x3 = kron(ak3', [1 zeros(1, Ns-1)]);
x = filter(hmef, 1, x3);

n0_3 = 16;
h3 = ones(1, Ns);
g3 = conv(hmef, h3);
bruitmax3 = 8;

EbN0db3 = 0:(bruitmax3);
EbN03=10.^(EbN0db3./10);

TEB3 = zeros(1,bruitmax3+1);
TEB_theorique3 = qfunc(sqrt((4/5)*EbN03));

for k=1:length(EbN0db3)
    rapp = EbN03(k);
    sigma3 = (mean(abs(x).^2)*Ns)/(2*log2(M3)*rapp);
    bruit3=sqrt(sigma3)*randn(1,length(x));
    
    if avecbruit == true
        signal_propage = x + bruit3;
    else
        signal_propage = x;
    end
    
    z3 = filter(h3, 1, signal_propage);
    
    z_echantillone3 = z3(n0_3:Ns:end);
    % %# Calcul du TEB
    % symboles_decides = zeros(1,length(z_echantillone3));
    % for i=1:length(z_echantillone3)
    %     if (z_echantillone3(i) >= 0)
    %         if (z_echantillone3 <= 2*Ns)
    %             symboles_decides(i) = 1;
    %         elseif (z_echantillone3(i) > 2*Ns)
    %             symboles_decides(i) = 3;
    %         end
    %     elseif (z_echantillone3(i) < 0)
    %         if ( -2*Ns <= z_echantillone3(i))
    %             symboles_decides(i) = -1;
    %         elseif (z_echantillone3(i) < -2*Ns)
    %             symboles_decides(i) = -3;
    %         end
    %     end
    % end
% symboles_decides = floor((symboles_decides + 3)/2)
% decisions3 = reshape(de2bi(symboles_decides).', 1, length(bits));    % Demapping
% taux_erreur3 = sum(decisions3 ~= bits) / length(bits);




    entiers_estimes = pamdemod((complex(z_echantillone3/Ns)),M3);
    decisions3 = reshape(de2bi(entiers_estimes)',1,[]);
    taux_erreur3 = sum(decisions3 ~= bits) / length(bits);
    TEB3(k) = taux_erreur3;

    %détecteur à seuil
    % symboles = zeros(1,length(z3(n0_3:Ns:end)));
    % symboles(z3(n0_3:Ns:end) > 2 * Ns) = 3;
    % symboles(z3(n0_3:Ns:end) >= 0 & z3(n0_3:Ns:end) <= 2 * Ns) = 1;
    % symboles(z3(n0_3:Ns:end) < -2 * Ns) = -3;
    % symboles(z3(n0_3:Ns:end) < 0 & z3(n0_3:Ns:end) >= -2 * Ns) = -1;
    % [~, rank] = ismember(symboles, mapping);
    % signal_sb_3 = reshape(de2bi(rank-1, 'left-msb'), 1, nbits); % demapping
    % signal_3 = zeros(1,length(signal_sb_3));
    % milieu = floor(length(signal_sb_3)/2);
    % cmptD = 1;
    % cmptG = 1;
    % for i=1:length(signal_sb_3)
    %     if (mod(i,2) == 0)
    %         signal_3(i) = signal_sb_3(milieu + cmptG);
    %         cmptG = cmptG + 1;
    %     else
    %         signal_3(i) = floor((i+1)/2) & signal_sb_3(cmptD);
    %         cmptD = cmptD + 1;
    %     end
    % end
    %taux_erreur3 = sum(signal_3 ~= bits) / nbits;
    

    if k == 1 
    plot3 = reshape(z3,Ns,length(z3)/Ns);
    end
end


if avecbruit == true
    figure
    nexttile
    plot(plot3);
    title("Diagramme de l'oeil de la chaine 3 avec Eb/N0 = 1 " )

    nexttile
    plot(reshape(z3,Ns,length(z3)/Ns));
    title("Diagramme de l'oeil de la chaine 3 avec Eb/N0 =  " + bruitmax3)

    figure 
    semilogy(EbN0db3,TEB3,'r');
    hold on 
    semilogy(EbN0db3,TEB_theorique3,'b');
    hold off
    legend('empirique', "theorique")
    
else
    figure
    nexttile
    plot(reshape(z3,Ns,length(z3)/Ns));
    title("Diagramme de l'oeil de la chaine 3 sans bruit"  )

    nexttile
    stem(g3);
    title("Tracé de la fct g pour la chaine 3")
end

%%%%%%%%%%%%% Partie 4 %%%%%%%%%%%%%%
if avecbruit == true 
figure 
semilogy(EbN0db,TEB1,'r');
hold on
semilogy(EbN0db2,TEB2,'b');
hold off
legend("TEB1", "TEB2")
xlabel('SNR(db)');
ylabel('TEB');

end

if avecbruit == true 
figure 
semilogy(EbN0db,TEB1,'r');
hold on
semilogy(EbN0db3,TEB3,'b');
hold off
legend("TEB1", "TEB3")
xlabel('SNR(db)');
ylabel('TEB');
end
