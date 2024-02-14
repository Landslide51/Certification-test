import random

import pandas as pd
import sklearn.preprocessing as preprocessing

lst = ['robot'] * 10
lst += ['human'] * 10

random.shuffle(lst)

data = pd.DataFrame({'WhoAmI': lst})
data.head()
# new_data = pd.get_dummies(data)
# print(new_data)

label_enc = preprocessing.LabelEncoder()
new_target = label_enc.fit_transform(data)
onehot_enc = preprocessing.OneHotEncoder()
onehot_enc.fit(new_target.reshape(-1, 1))
targets_trans = onehot_enc.transform(new_target.reshape(-1, 1))
print('The original data')
print(data)
print('The transformed data')
print(targets_trans.toarray())