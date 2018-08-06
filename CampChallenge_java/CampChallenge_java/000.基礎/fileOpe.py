
import numpy as np
import matplotlib.pylab as plt
import gzip
import csv


# MNISTデータのローディング
def load_mnist(normaliz=True, one_hot=True):

    (x_train, t_train), (x_test, t_test) = (None, None), (None, None)

    file_path = {
        'x_train':'dataset/train-images-idx3-ubyte.gz',
        't_train':'dataset/train-labels-idx1-ubyte.gz',
        'x_test':'dataset/t10k-images-idx3-ubyte.gz',
        't_test':'dataset/t10k-labels-idx1-ubyte.gz'
    }

    with gzip.open(file_path['x_train'], 'rb') as f:
        data = np.frombuffer(f.read(), np.uint8, offset=16)
        data = data.reshape(60000, 784)
        if normaliz == True:
            data = data / 255.0
        x_train = data

    with gzip.open(file_path['t_train'], 'rb') as f:
        data = np.frombuffer(f.read(), np.uint8, offset=8)
        if one_hot == True:
            data = np.identity(10)[data]
        t_train = data

    with gzip.open(file_path['x_test'], 'rb') as f:
        data = np.frombuffer(f.read(), np.uint8, offset=16)
        data = data.reshape(10000, 784)
        if normaliz == True:
            data = data / 255.0
        x_test = data

    with gzip.open(file_path['t_test'], 'rb') as f:
        data = np.frombuffer(f.read(), np.uint8, offset=8)
        if one_hot == True:
            data = np.identity(10)[data]
        t_test = data


    return (x_train, t_train), (x_test, t_test)






# 学習結果をファイルに保存
def exportWeight(weight):
    W1 = weight['W1']
    b1 = weight['b1']
    W2 = weight['W2']
    b2 = weight['b2']

    with open('./learned/weight/W1.csv', 'w', newline='') as f:
        writer = csv.writer(f)
        for value in W1:
            writer.writerow(value)

    with open('./learned/weight/b1.csv', 'w', newline='') as f:
        writer = csv.writer(f)
        writer.writerow(b1)

    with open('./learned/weight/W2.csv', 'w', newline='') as f:
        writer = csv.writer(f)
        for value in W2:
            writer.writerow(value)

    with open('./learned/weight/b2.csv', 'w', newline='') as f:
        writer = csv.writer(f)
        writer.writerow(b2)


# 学習済みの重みをインポート
def importWeight(derectryName):
    weight = {}
    temp = np.array([])

    with open('./' + derectryName + '/weight/W1.csv', 'r') as f:
        W1 = np.zeros((784,100))
        reader = csv.reader(f)
        y = 0
        for row in reader :
            x = 0
            for value in row:
                W1[y, x] = np.append(temp, float(value))
                x = x + 1
            y = y + 1
        weight['W1'] = W1

    with open('./' + derectryName + '/weight/b1.csv', 'r') as f:
        b1 = np.zeros(100)
        reader = csv.reader(f)
        for row in reader:
            x = 0
            for value in row:
                b1[x] = np.append(temp, float(value))
                x = x + 1
        weight['b1'] = b1

    with open('./' + derectryName + '/weight/W2.csv', 'r') as f:
        W2 = np.zeros((100,10))
        reader = csv.reader(f)
        y = 0
        for row in reader :
            x = 0
            for value in row:
                W2[y, x] = np.append(temp, float(value))
                x = x + 1
            y = y + 1
        weight['W2'] = W2

    with open('./' + derectryName + '/weight/b2.csv', 'r') as f:
        b2 = np.zeros(10)
        reader = csv.reader(f)
        for row in reader:
            x = 0
            for value in row:
                b2[x] = np.append(temp, float(value))
                x = x + 1
        weight['b2'] = b2

    return weight

# loss_plot, accuracy_plotをファイル書き出し
def export_loss_accuracy(loss, accuracy):
    with open('./learned/plot/loss.csv', 'w', newline='') as f:
        writer = csv.writer(f)
        writer.writerow(loss)
    with open('./learned/plot/accuracy.csv', 'w', newline='') as f:
        writer = csv.writer(f)
        writer.writerow(accuracy)


# グラフ表示
def grapf_display(derectryName):
    loss_array = np.array([])
    temp = np.array([])
    with open('./' + derectryName + '/plot/loss.csv', 'r') as f:
        reader = csv.reader(f)
        for row in reader:
            for value in row:
                loss_array = np.append(loss_array, float(value))
    loss_x = np.arange(0, loss_array.size, 1)

    accuracy_array = np.array([])
    temp = np.array([])
    with open('./' + derectryName + '/plot/accuracy.csv', 'r') as f:
        reader = csv.reader(f)
        for row in reader:
            for value in row:
                accuracy_array = np.append(accuracy_array, float(value))
    accuracy_x = np.arange(0, accuracy_array.size, 1)

    plt.figure(figsize=(17, 5))
    plt.subplot(1, 2, 1)
    plt.plot(accuracy_x, accuracy_array)
    plt.subplot(1, 2, 2)
    plt.plot(loss_x, loss_array)
    plt.show()