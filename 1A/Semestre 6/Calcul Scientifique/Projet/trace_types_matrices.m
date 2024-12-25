% Générer des matrices de chaque type et extraire les valeurs propres
n = 100; % Taille de la matrice
[~, D1, ~] = matgen_csad(1, n);
[~, D2, ~] = matgen_csad(2, n);
[~, D3, ~] = matgen_csad(3, n);
[~, D4, ~] = matgen_csad(4, n);

indices_1 = 1:numel(D1);
indices_2 = 1:numel(D2);
indices_3 = 1:numel(D3);
indices_4 = 1:numel(D4);

% Tracer les distributions des valeurs propres
figure;

% Matrice de Type 1
subplot(2, 2, 1);
bar(indices_1, D1);
title('Matrice de Type 1');
ylim([0, max(D1)]);

% Matrice de Type 2
subplot(2, 2, 2);
bar(indices_2, D2);
title('Matrice de Type 2');
ylim([0, max(D2)]);

% Matrice de Type 3
subplot(2, 2, 3);
bar(indices_3, D3);
title('Matrice de Type 3');
ylim([0, max(D3)]);

% Matrice de Type 4
subplot(2, 2, 4);
bar(indices_4, D4);
title('Matrice de Type 4');
ylim([0, max(D4)]);
