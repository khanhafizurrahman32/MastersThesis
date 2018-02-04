function [ C CLabel ] = GetMean( X ,XLabel)
%Input:   
%       X:           data matrix (Each column is a data point)
%       XLabel:      Row vector of the label information for each data point

%Output:     
%       C:           the mean matrix of the data point
%       CLabel:      Row vector of the label information for C    
%--------------------------------------------------------------------------
 
CLabel=unique(XLabel);
k=0;
for i=CLabel
    loc=find(XLabel==i);
    k=k+1;
    C(:,k)=mean(X(:,loc),2);
end


end

