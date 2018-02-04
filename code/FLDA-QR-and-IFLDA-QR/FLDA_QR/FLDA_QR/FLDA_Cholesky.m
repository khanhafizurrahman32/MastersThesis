function [G,Q,C,CPU_TIME]  = FLDA_Cholesky(A,ALabel)
%Input:   
%       A:           data matrix (Each column is a data point)
%       ALabel:      Row vector of the label information for each data point

%Output:     
%       G:           Transformation matrix  
%       Q:           Orthogonal matrix
%       C:           the mean matrix of the data point
%       CPU_TIME:    Computational time    
%--------------------------------------------------------------------------
 
tstart = tic();

[C CLabel] = GetMean( A ,ALabel);

L=C'*C;
R=chol(L);
R_Inv=inv(R);
Q=C*R_Inv;

G=Q*R_Inv';

CPU_TIME = toc(tstart);

end